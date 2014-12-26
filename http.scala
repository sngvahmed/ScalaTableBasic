//package bot
//
//import java.io._
//import org.apache.commons._
//import org.apache.http._
//import org.apache.http.client._
//import org.apache.http.client.methods.HttpPost
//import org.apache.http.impl.client.DefaultHttpClient
//import java.util.ArrayList
//import org.apache.http.message.BasicNameValuePair
//import org.apache.http.client.entity.UrlEncodedFormEntity
//import org.apache.http.client.methods.HttpGet
//
//object HttpPostTester {
//
//  def main(args: Array[String]) {
//
//    val url = "http://codeforces.com/api/problemset.recentStatus?count=1";
//    val httpGet = new HttpGet(url)
//
//    // execute the request
//    val client = new DefaultHttpClient
//    var respons = client.execute(httpGet)
//
//    println(respons)
//    client.getConnectionManager.shutdown
//
//  }
//
//}