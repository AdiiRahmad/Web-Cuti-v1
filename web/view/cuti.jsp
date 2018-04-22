<%-- 
    Document   : cuti
    Created on : Apr 16, 2018, 4:35:24 PM
    Author     : Siti Khusnul Azifah
--%>

<%@page import="entities.Cuti"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cuti</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery.js"></script>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="{{ asset('../css/style.css') }}">

        <!-- Bootstrap -->
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="../css/font-awesome.min.css">
        <link rel="stylesheet" href="../css/font-awesome.css">
        <link rel="stylesheet" href="../css/animate.css">
        <link href="../css/style.css" rel="stylesheet" />
    </head>
    <body>
    <br><center><h3><b>Data Cuti</b></h3></center><br>
    <div class="col-lg-8 col-lg-offset-2">
        <a class="btn btn-primary" href="cutiAutoID" role="button">Tambah Data</a><br><br>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th scope="col">No</th>
                    <th scope="col">ID Cuti</th>
                    <th scope="col">Jenis Cuti</th>
                    <th scope="col">Durasi Cuti</th>
                    <th scope="col">Keterangan</th>
                    <th scope="col">Aksi</th>
                </tr>
            </thead>
            <%
//                List<Object> datas = new CutiDAO().getAll();
                List<Object> datas = (List<Object>) session.getAttribute("dataCutis");
                int i = 1;
                for (Object data : datas) {
                    Cuti c = (Cuti) data;
            %>
            <tbody>
                <tr>
                    <td><%= i++%></td>
                    <td><%= c.getIdCuti()%></td>
                    <td><%= c.getJenisCuti()%></td>
                    <td><%= c.getDurasi()%></td>
                    <td><%= c.getKeterangan()%></td>
                    <td><center>
                        <a class="btn btn-primary btn-xs" href="cutiU?id=<%= c.getIdCuti() %>" role="button">Edit</a>
                        <a class="btn btn-danger btn-xs" href="cutiD?id=<%= c.getIdCuti() %>" role="button">Delete</a>                        
                    </center></td>
                </tr>
            </tbody>
            <%
                }
            %>
        </table>
    </div>
</body>
</html>
