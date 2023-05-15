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
package org.github.baker.internal.example.invoke;

/**
 * <p></p>
 *
 * @author luohuiqi
 * @date 2023/5/12 15:38
 */
public class InvokeTest {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("org.github.baker.internal.inter.UserMapper");
        System.out.println("aClass = " + aClass);
    }
}
