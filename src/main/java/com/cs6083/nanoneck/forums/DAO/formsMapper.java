package com.cs6083.nanoneck.forums.DAO;

import com.cs6083.nanoneck.User.pojo.answer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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
          + "values (null, #{tid}, #{uid},#{qTitle}, #{qBody},now(),null,null);")
  void insertPost(int tid, int uid, String qTitle, String qBody);

  @Select(
      "select * from Questions join Topics T on T.tid = Questions.tid\n"
          + " join User U on U.uid = Questions.uid\n"
          + " where Match(qTitle) Against('${qTitle}')\n"
          + " order by (0.8 * Match(qTitle) Against('${qTitle}' in boolean mode ))  desc;")
  List<Map<String, Object>> SearchQuestionsByTitle(String qTitle);

  @Select("select * from Questions  join User U on Questions.uid = U.uid where qid=#{qid};")
  Map<String,Object> getQuestionById(int qid);

  @Insert(
      "insert into Answers(aid, uid, qid, answer_text, answer_created_time, thumbs_up_num)\n"
          + "values (null,#{uid},#{qid},#{answer_text},now(),0) ;")
  void submitReplay(int uid, String qid, String answer_text);

  @Update("update Answers set thumbs_up_num = thumbs_up_num+1 where aid=#{aid};")
  void addLike(String aid);
}
