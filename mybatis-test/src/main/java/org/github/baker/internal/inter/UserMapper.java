/**
 *    Copyright ${license.git.copyrightYears} the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.github.baker.internal.inter;

import org.apache.ibatis.annotations.Param;
import org.github.baker.internal.entity.User;

import java.util.List;

/**
 * <p>user服务</p>
 *
 * @author luohuiqi
 * @date : 2023/5/11 14:36
 **/
public interface UserMapper {

    User selectById(@Param("id") Long id);

    List<User> selectAllUser();
}
