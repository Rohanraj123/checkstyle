/*xml
<module name="Checker">
  <module name="TreeWalker">
    <module name="SuppressWithNearbyCommentFilter">
      <property name="commentFormat"
        value="@cs\.suppress \[(\w+(\|\w+)*)\] \w[-\.'`,:;\w ]{14,}"/>
      <property name="checkFormat" value="$1"/>
      <property name="influenceFormat" value="1"/>
    </module>
    <module name="RegexpSinglelineJava">
      <property name="id" value="ignore"/>
      <property name="format" value="^.*@Ignore\s*$"/>
      <property name="message" value="@Ignore should have a reason."/>
    </module>
    <module name="RegexpSinglelineJava">
      <property name="id" value="systemout"/>
      <property name="format" value="^.*System\.\(out|err\).*$"/>
      <property name="message" value="Don't use System.out/err, use SLF4J instead."/>
    </module>
  </module>
</module>
*/
package com.puppycrawl.tools.checkstyle.filters.suppresswithnearbycommentfilter;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

// xdoc section -- start
public class Example7 {
  @Ignore // @cs-: ignore (test has not been implemented yet)
  @Test
  public void testMethod() {}

  public static void foo() {

    System.out.println("Debug info."); // @cs-: systemout (should not fail)
  }
}
// xdoc section -- end
