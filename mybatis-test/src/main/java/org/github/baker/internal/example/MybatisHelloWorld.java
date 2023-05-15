/**
 * Copyright ${license.git.copyrightYears} the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.github.baker.internal.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.github.baker.internal.entity.User;
import org.github.baker.internal.inter.UserMapper;

import java.io.IOException;
import java.io.Reader;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhubo
 * @description:
 * @time: 2018年10月20日
 * @modifytime:
 */
public class MybatisHelloWorld {

    public static void main(String[] args) {
        String resource = "Configuration.xml";

        try (Reader reader = Resources.getResourceAsReader(resource)) {
            // 解析classpath下的所有xml为Configuration，且构建为DefaultSqlSessionFactory
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
            // 准备执行器execute  ==>DefaultSqlSession
            try (SqlSession session = sqlMapper.openSession()) {
                User user = session.selectOne("org.github.baker.internal.inter.UserMapper.selectById", 1L);
//               List<User> users = session.selectList("org.github.baker.internal.inter.UserInterface.selectAllUser");
                // 1.statement 唯一标识
                System.out.println("statement：" + user);
                // 2.接口直接访问
                UserMapper mapper = session.getMapper(UserMapper.class);
                User mapperUser = mapper.selectById(1L);
                System.out.println("mapperUser：" + mapperUser);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
