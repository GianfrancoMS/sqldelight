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
package com.squareup.sqldelight.util

import org.antlr.v4.runtime.tree.TerminalNode

internal fun javadocText(javadoc: TerminalNode?) : String? {
  if (javadoc == null) return null
  return javadoc.text.removeSurrounding("/**", "*/").trim('\n', ' ').lines()
      .joinToString("\n") { it.removePrefix("*").trim() } + '\n'
}
