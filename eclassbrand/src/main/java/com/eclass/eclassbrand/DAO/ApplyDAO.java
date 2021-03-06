package com.eclass.eclassbrand.DAO;

import com.eclass.eclassbrand.POJO.Apply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ApplyDAO extends JpaRepository<Apply, Long> {


    @Query(value = "select * from apply where state=?1",nativeQuery = true)
    Page<Apply> findByState(String state, Pageable pageable);


    List<Apply> findByWeekAndDayOfWeekAndClassroomLikeAndState(int week,String theday,String build,String state);

    @Query(value = "select * from apply where week=:week and day_of_week=:day and state=:state and classroom LIKE CONCAT('%',:build,'%')",nativeQuery = true)
    List<Apply> findByWeekAndDayOfWeekAndStateAndClassroomContaining(@Param("week")int week, @Param("day")String day, @Param("state")String state,@Param("build")String build);


    @Query(value = "select * from apply where week=?1 and day_of_week=?2 and state=?3",nativeQuery = true)
    List<Apply> findByWeekAndDayOfWeekAndState(int week,String theday,String state);

    //获取当天所有通过的申请
    @Query(value = "select * from apply where week=?1 and day_of_week=?2 and classroom=?3", nativeQuery = true)
    List<Apply> findApplyOfDay(int week,String dayOfWeek,String classroom);

    @Query(value = "select * from apply where sid=?1", nativeQuery = true)
    List<Apply> findBySid(int sid);


}
