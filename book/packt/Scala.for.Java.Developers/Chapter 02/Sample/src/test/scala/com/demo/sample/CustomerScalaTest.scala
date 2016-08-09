package com.demo.sample

import org.junit._
import Assert._

class CustomerScalaTest {

  @Before
  def setUp: Unit = {
  }

  @After
  def tearDown: Unit = {
  }

  @Test
  def testGetCustomerId = {
    System.out.println("getCustomerId")
    val instance = new Customer()
    val expResult: Integer = null
    val result: Integer = instance.getCustomerId()
    assertEquals(expResult, result)
  }
}
