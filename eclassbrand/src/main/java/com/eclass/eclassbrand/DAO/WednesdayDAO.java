package com.eclass.eclassbrand.DAO;


import com.eclass.eclassbrand.POJO.DayOfWeek;
import com.eclass.eclassbrand.POJO.Wednesday;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface WednesdayDAO extends JpaRepository<Wednesday,Long>,BasicDAOOfDay {
    //根据楼名找安排
    @Query(value = "select * from wednesday where classroom LIKE ?1 and find_in_set(?2,week)", nativeQuery = true)
    List<DayOfWeek> findByClassroomLike(String classroom, int week );

    @Query(value ="select * from wednesday where find_in_set(?1,week) order by start",nativeQuery = true)
    List<DayOfWeek> findAllByOrderByStart(int week);

    List<Wednesday> findByCno(String cno);

    List<Wednesday> findByTno(String tno);

    //查询该栋楼所有教室
    @Query(value = "select distinct classroom from wednesday where classroom like ?1 and find_in_set(?2,week)",nativeQuery = true)
    Page<String> getClassroom(String build, int week, Pageable pageable);

    //获取该表所有教室
    @Query(value = "select distinct classroom from wednesday where find_in_set(?1,week)",nativeQuery = true)
    List<String> getAllClassroom(int week);

    //获取某教室当天日程
    @Query(value = "select * from wednesday where find_in_set(?1,week) and classroom=?2",nativeQuery = true)
    List<DayOfWeek> getScheduleOfClass(int week,String classroom);
}
