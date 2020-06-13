package com.hhl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hhl.entity.Person;
import com.hhl.mapper.PersonMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@SpringBootTest(classes = HelloSpringbootApplication.class)
@RunWith(value = SpringRunner.class)
@Transactional
@Rollback
public class TkMybatisTests {
    @Autowired
    private PersonMapper personMapper;
    @Test
    public void testSelect(){
        List<Person> people = personMapper.selectAll();
        for (Person person : people) {
            System.out.println(person);
        }
    }
    @Test
    public void testPageQuery(){
        PageHelper.startPage(1,3);
        Example example = new Example(Person.class);
        PageInfo<Person> pageInfo = new PageInfo<>(personMapper.selectByExample(example));
        List<Person> list = pageInfo.getList();
        for (Person person : list) {
            System.out.println(person);
        }
    }
}
