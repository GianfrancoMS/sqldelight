/*
 * Copyright (C) 2016 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.squareup.sqldelight.core.lang

import com.alecstrong.sqlite.psi.core.SqliteParserDefinition
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.lang.parser.GeneratedParserUtilBase.Parser
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IFileElementType
import com.squareup.sqldelight.core.SqldelightParserUtil

class SqlDelightParserDefinition: SqliteParserDefinition() {
  init {
    SqldelightParserUtil.overrideSqliteParser()
  }

  override fun createFile(viewProvider: FileViewProvider) = SqlDelightFile(viewProvider)
  override fun getFileNodeType() = FILE
  override fun getLanguage() = SqlDelightLanguage

  companion object {
    private val FILE = IFileElementType(SqlDelightLanguage)
  }
}