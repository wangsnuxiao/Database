package com.cs6083.nanoneck.forums.DAO;

import com.cs6083.nanoneck.User.pojo.answer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface formsMapper {
  @Select(
      "select username,aid, User.uid, Questions.qid,\n"
          + "       answer_text,answer_created_time,thumbs_up_num\n"
          + "                from Questions join Answers on Questions.qid = Answers.qid\n"
          + "                 join User on User.uid = Answers.uid\n"
          + "                join Topics on Topics.tid = Questions.tid\n"
          + "                Where Questions.qid = #{id}\n"
          + "                Order by thumbs_up_num desc;")
  List<answer> getAnswerByQuestionId(int id);

  @Insert(
      "insert into Questions(qid, tid, uid, qTitle, qBody, question_created_time, question_solved_time, bestAnswer)\n"
          + "values (null, #{tid}, #{uid},#{qTitle}, qBody,now(),null,null);")
  void insertPost(int tid, int uid, String qTitle, String qBody);
}
