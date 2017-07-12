package com.jumore.zhxf.service;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jumore.zhxf.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class UserInfoServiceTest {

    private static final String CLASSPATH_EXCEL_FOR_TEST
            = "ksbysample/eipapp/dirchecker/service/userinfo/Book1.xlsx";


    @Autowired
    private DataSource dataSource;


    @Test
    public void loadFromExcelToList() throws Exception {
        Resource resource = new ClassPathResource(CLASSPATH_EXCEL_FOR_TEST);
       /* List<WorkOvertimeRow> userInfoExcelRowList = userInfoService.loadFromExcelToList(resource.getFile());
        assertThat(userInfoExcelRowList).hasSize(2);
        assertThat(userInfoExcelRowList).extracting("username", "password", "mailAddress", "roles")
                .containsOnly(tuple("yota takahashi", "12345678", "yota.takahashi@test.co.jp", "ROLE_USER")
                        , tuple("aoi inoue", "abcdefgh", "aoi.inoue@sample.com", "ROLE_ADMIN,ROLE_USER"));*/
    }

    @Test
    public void loadUserInfoFromExcel() throws Exception {
        Resource resource = new ClassPathResource(CLASSPATH_EXCEL_FOR_TEST);
       // userInfoService.loadUserInfoFromExcel(resource.getFile());
/*
        IDataSet dataSet = new CsvDataSet(new File("src/test/resources/ksbysample/eipapp/dirchecker/service/userinfo/assertdata/001"));
        TableDataAssert tableDataAssert = new TableDataAssert(dataSet, dataSource);
        tableDataAssert.assertEqualsByQuery(
                "select username, mail_address, enabled, cnt_badcredentials from user_info order by user_id"
                , "user_info"
                , new String[]{"username", "mail_address", "enabled", "cnt_badcredentials"}
                , AssertOptions.INCLUDE_COLUMN);
        tableDataAssert.assertEqualsByQuery("select role from user_role order by user_id, role_id"
                , "user_role"
                , new String[]{"role"}
                , AssertOptions.INCLUDE_COLUMN);*/
    }

}