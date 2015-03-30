<%@page import="java.util.Date"%>
<%@page import="utbm.java.project.SchoolCourse.Main"%>
<%@page import="utbm.java.project.SchoolCourse.Course"%>
<%@page import="utbm.java.project.SchoolCourse.SettingPage"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>
	<head>
		<title>UTBM Course Registration</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<!--[if lte IE 8]><script src="/SchoolCourse/css/ie/html5shiv.js"></script><![endif]-->
		<script src="/SchoolCourse/js/jquery.min.js"></script>
		<script src="/SchoolCourse/js/jquery.scrolly.min.js"></script>
		<script src="/SchoolCourse/js/jquery.poptrox.min.js"></script>
		<script src="/SchoolCourse/js/skel.min.js"></script>
		<script src="/SchoolCourse/js/init.js"></script>
		<noscript>
			<link rel="stylesheet" href="/SchoolCourse/css/skel.css" />
			<link rel="stylesheet" href="/SchoolCourse/css/style.css" />
		</noscript>
		<!--[if lte IE 8]><link rel="stylesheet" href="/SchoolCourse/css/ie/v8.css" /><![endif]-->
	</head>
	<body>

		<!-- Header -->
			<section id="header">
				<header>
					<h1>UTBM</h1>
					<p>Course Registration</p>
				</header>
				<footer>
					<a href="#banner" class="button style2 scrolly-middle">Register</a>
				</footer>
			</section>

		<!-- Banner -->
			<section id="banner">
				<header>
					<h2>Caution</h2>
				</header>
				<p>All your personal data will be recored in our database.<br/> To continue the registration, you must agree with all the terms.</p>
				<footer>
					<a href="#first" class="button style2 scrolly">I agree</a>
				</footer>
			</section>

		<!-- Feature 1 -->
			<article id="first" class="container box style1 right">
				<a href="#" class="image fit"><img src="/SchoolCourse/images/course1.png" alt="" /></a>
				<div class="inner">
					<header>
						<h2>Object-oriented Java programming</h2>
					</header>
					<p>Professor Patrick<br/>Code AA01<br/>Credits 6<br/>Day Monday 13:00 - 16:00</p>
				</div>
			</article>

		<!-- Feature 2 -->
			<article class="container box style1 left">
				<a href="#" class="image fit"><img src="/SchoolCourse/images/course2.png" alt="" /></a>
				<div class="inner">
					<header>
						<h2>.NET Object–Oriented Programming Using C#</h2>
					</header>
					<p>Professor Robbins<br/>Code AA02<br/>Credits 6<br/>Day Tuesday 10:30 - 13:30</p>
				</div>
			</article>

			<article class="container box style3">
				<section>
					<header>
						<h3>Register List ALL</h3>
					</header>
					<form method="post" action="/SchoolCourse/RegisterServlet">
						<div class="row">
							<div class="6u">
								<input class="text" type="text" name="firstName" id="firstName" value="" placeholder="First Name" />
							</div>
							<div class="6u">
								<input class="text" type="text" name="lastName" id="lastName" value="" placeholder="Last Name" />
							</div>
						</div>
						<div class="row">
							<div class="12u">
								<input class="text" type="text" name="email" id="email" value="" 	placeholder="E-MAIL" />
							</div>
						</div>
						<div class="row">
							<div class="12u">
								<input class="text" type="text" name="address" id="address" value="" placeholder="Address" />
							</div>
						</div>
						<div class="row">
							<div class="12u">
								<input class="text" type="text" name="phone" id="phone" value="" placeholder="Phone" />
							</div>
						</div>
						<div class="row">
							<div class="12u">
								<select name="course" id="course">
									<option value="">Choose a course</option>
									<%
										SettingPage setPage = new SettingPage();
										List<Course> courseList = setPage.gettingCourseList();
										for (int i = 0; i < courseList.size(); i++) {
											Course course = courseList.get(i);
									%>
									<option value=<%=course.getCode()%>><%=course.getTitle() + "-Code-" + course.getCode()%></option>
										<%
											}
										%>
								</select>
							</div>
						</div>
						<!--
						<div class="row">
							<div class="12u">
								<input class="text" type="text" name="code" id="code" value="" placeholder="Enter Code" />
							</div>
						</div>
						-->
						<div class="row">
							<div class="12u">
								<ul class="actions">
									<li><input type="submit" value="Submit" /></li>
									<li><input type="reset" class="style3" value="Clear Form" /></li>
								</ul>
							</div>
						</div>
					</form>
				</section>
			</article>
		
		<article class="container box style3">
				<section>
					<header>
						<h3>Filter</h3>
					</header>
					<form method="post" action="/SchoolCourse/FilterServlet">
						<div class="row">
							<div class="12u">
								<input class="text" type="text" name="className" id="className" value="" placeholder="Type in Class Name" />
							</div>
						</div>
						<div class="row">
							<div class="12u">
								<select name="location" id="location">
									<option value="">Choose a location</option>
								</select>
							</div>
						</div>
						<div class="row">
							<div class="12u">
								<ul class="actions">
									<li><input type="submit" value="Submit" /></li>
									<li><input type="reset" class="style3" value="Clear Filter" /></li>
								</ul>
							</div>
						</div>
					</form>
				</section>
			</article>



		<section id="footer">
		<!-- 
			<ul class="icons">
				<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
				<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
				<li><a href="#" class="icon fa-google-plus"><span class="label">Google+</span></a></li>
				<li><a href="#" class="icon fa-pinterest"><span class="label">Pinterest</span></a></li>
				<li><a href="#" class="icon fa-dribbble"><span class="label">Dribbble</span></a></li>
				<li><a href="#" class="icon fa-linkedin"><span class="label">LinkedIn</span></a></li>
			</ul>
			 -->
			<div class="copyright">
				<ul class="menu">
					<li>&copy; Untitled. All rights reserved.</li><li>Design: <a href="http://html5up.net">Evan</a></li>
				</ul>
			</div>
		</section>

	</body>
</html>