<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Information</title>
    </head>
    <body>
        <h1>Student Information</h1>
        <form action="./StudentInfo" method="POST">
            <table>
                <tr>
                    <td>Student Id</td>
                    <td><input type="text" name="studentid" value="${student.studentid}" /></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="firstname" value="${student.firstname}" /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastname" value="${student.lastname}" /></td>
                </tr>
                <tr>
                    <td>Year Level</td>
                    <td><input type="text" name="yearlevel" value="${student.yearlevel}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Year Level</th>
                <c:forEach items="${allStudent}" var="stud">
                <tr>
                    <td>${stud.studentid}</td>
                    <td>${stud.firstname}</td>
                    <td>${stud.lastname}</td>
                    <td>${stud.yearlevel}</td>
                </tr>
            </c:forEach> 
        </table>

        <h1>Añadir Estudiante a Clase</h1>
        <form action="./CursoInfo" method="POST">
            <table>
                <tr>
                    <td>Student id</td>
                    <td><input type="text" name="studentId" value="${stuSub.studentid}" /></td>
                </tr>
                <tr>
                    <td>Subject Id</td>
                    <td><input type="text" name="subId" value="${stuSub.subjectid}" /></td>
                </tr>
                <tr>
                    <td>Grade</td>
                    <td><input type="text" name="grade" value="${stuSub.grade}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                    </td>
                </tr>
            </table>
        </form> 
        <br>

        <h1>INFORMACION ESTUDIANTE</h1>
         <form action="./SubInfo" method="POST">
            <table>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" value="${subInf.name}" /></td>
                </tr>
                <tr>
                    <td>Code</td>
                    <td><input type="text" name="code" value="${subInf.code}" /></td>
                </tr>
                <tr>
                    <td>Credit</td>
                    <td><input type="text" name="credit" value="${subInf.credit}" /></td>
                </tr>
                <tr>
                    <td>Semester</td>
                    <td><input type="text" name="semester" value="${subInf.semester}" /></td>
                </tr>
                <tr>
                    <td>Amount of students</td>
                    <td><input type="text" name="cantity" value="${subInf.cantity}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form> 
    </body>
</html>
