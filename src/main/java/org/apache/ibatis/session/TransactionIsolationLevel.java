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
package org.apache.ibatis.session;

import java.sql.Connection;

/**
 * @author Clinton Begin
 * 事物隔离级别
 *
 *
 */
public enum TransactionIsolationLevel {
  /**
   * 无隔离
   */
  NONE(Connection.TRANSACTION_NONE),

  /**
   * 读已提交（A有未提交的）
   */
  READ_COMMITTED(Connection.TRANSACTION_READ_COMMITTED),

  /**
   * 读未提交（可以读到未提交的数据，会导致脏读，幻读以及不可重复读）
   */
  READ_UNCOMMITTED(Connection.TRANSACTION_READ_UNCOMMITTED),

  /**
   * 可重复读（在读期间加锁）
   */
  REPEATABLE_READ(Connection.TRANSACTION_REPEATABLE_READ),
  /**
   *
   */
  SERIALIZABLE(Connection.TRANSACTION_SERIALIZABLE);

  private final int level;

  TransactionIsolationLevel(int level) {
    this.level = level;
  }

  public int getLevel() {
    return level;
  }
}
