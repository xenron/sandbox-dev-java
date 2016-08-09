package com.samples

import dispatch._, Defaults._

object WorkingWithHTTP {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(139); 
  val request = url("http://freegeoip.net/xml/www.google.com");System.out.println("""request  : dispatch.Req = """ + $show(request ));$skip(43); 
  val result = Http( request OK as.String);System.out.println("""result  : dispatch.Future[String] = """ + $show(result ));$skip(32); 
  val resultAsString = result();System.out.println("""resultAsString  : String = """ + $show(resultAsString ))}
}
