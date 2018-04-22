<%-- 
    Document   : jabatan
    Created on : Apr 16, 2018, 4:35:52 PM
    Author     : Siti Khusnul Azifah
--%>

<%@page import="entities.Jabatan"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <head>
        <title>Jabatan</title>
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
        <br><center><h3><b>Data Jabatan</b></h3></center><br>
        <div class="col-lg-6 col-lg-offset-3">
            <a class="btn btn-primary" href="jabatanAutoID" role="button">Tambah Data</a><br><br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">No</th>
                        <th scope="col">ID Jabatan</th>
                        <th scope="col">Jabatan</th>
                        <th scope="col">ID Pimpinan</th>
                        <th scope="col">Aksi</th>
                    </tr>
                </thead>
                <%
    //                List<Object> datas = new CutiDAO().getAll();
                    List<Object> datas = (List<Object>) session.getAttribute("dataJabatans");
                    int i = 1;
                    for (Object data : datas) {
                        Jabatan j = (Jabatan) data;
                %>
                <tbody>
                    <tr>
                        <td><%= i++ %></td>
                        <td><%= j.getIdJabatan() %></td>
                        <td><%= j.getJabatan() %></td>
                        <td><%= j.getIdPimpinan() %></td>
                        <td><center>
                            <a class="btn btn-primary btn-xs" href="jabatanU?id=<%= j.getIdJabatan() %>" role="button">Edit</a>
                            <a class="btn btn-danger btn-xs" href="jabatanD?id=<%= j.getIdJabatan() %>" role="button">Delete</a>                        
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
