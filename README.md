<h1>Spring Boot Web App</h1>
<h4>Video Demo:  https://www.youtube.com/watch?v=rAD9fJYRBgk</h4>

<h3>Edx Username: nivkapadia</h3>
<h3>github Username: nivkapadia</h3>
<hr>
<h3> About the application</h3>
<p>
    This spring boot web application uses the following dependencies:
</p>
<ul>
    <li>H2 - Database</li>        
    <li>Lombok</li>        
    <li>Spring Security</li>        
    <li>Thymeleaf</li>        
    <li>Spring Data JDBC</li>        
    <li>Spring Dev Tools</li>        
    <li>Spring Web</li>        
</ul>

<p>
    What this spring web app does is authenticate users based on information stored in the database, if the information is not available in the database, the user can not login. The web app limits the functionality based on the role of the logged in user. Example: Admin has more functionality than a guest user. The database stores encrypted password in database (more on encryption details later). The web app will essentially allow the user, as per their permissions, to view the books from book table and authors from author table in the database.
    The database contains the following tables:
    </p>
    <ul>
        <li>USERS</li>
        <li>ROLE</li>
        <li>USERROLE</li>
        <li>BOOK</li>
        <li>AUTHOR</li>
        <li>AUTHORBOOK</li>
    </ul>
    <p>
    The main functionality of this web app and the most difficult part about it is it's "SecurityFilterChain" method which is located in src/com.nivkapadia.security/SecurityConfig.java where you can find use of antMatchers in order to check the url and react/respond as per the user logged in.
    By default, the user is redirected to an unsecured index page which anyone can access.
    This web app uses an in-memory H2 database.
    </p>

<p>
    The USERS table stores user email and encrypted password. The encryption used is BCrypt encryption. And when the user logs in, the web app uses BCryptPasswordEncoder method to verifty the encrypted password.
</p>

<p>
    The roles in this webapp are:
</p>
<ol>
    <li>ADMIN</li>
    <li>USER</li>
    <li>GUEST</li>
</ol>

<p>Each has it's own functionality</p>

<p>
    The ADMIN role has the following functionality:
</p>
<ul>
    <li>View all the users in DB</li>
    <li>View Books</li>
    <li>View Authors</li>
    <li>Add and Delete Books</li>
    <li>Add and Delete Authors</li>
    <li>View unsecured index page</li>
</ul>
<p>
    The USER role has the following functionality:
</p>
<ul>
    <li>View Books</li>
    <li>View Authors</li>
    <li>View unsecured index page</li>
</ul>

<p>
    The GUEST role has the following functionality:
</p>
<ul>
    <li>View unsecured index page</li>
</ul>