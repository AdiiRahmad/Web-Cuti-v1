<%-- 
    Document   : laporanpersetujuancuti
    Created on : Apr 18, 2018, 2:02:57 AM
    Author     : Siti Khusnul Azifah
--%>

<%@page import="entities.SetujuCuti"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Laporan Persetujuan Cuti</title>
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
        <br><center><h3><b>Data Persetujuan Cuti</b></h3></center><br>
        <div class="col-lg-8 col-lg-offset-2">
            <%
                SetujuCuti set = new SetujuCuti();
            %>
            <a class="btn btn-primary" href="controllerPrintAll" role="button">Download All</a>&nbsp;&nbsp;
            <a class="btn btn-primary" href="controllerPrintSearch" role="button">Download Search</a><br><br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">No</th>
                        <th scope="col">ID Setuju Cuti</th>
                        <th scope="col">ID Detail Cuti</th>
                        <th scope="col">Status</th>
                        <th scope="col">ID Jabatan</th>
                        <th scope="col">Aksi</th>
                    </tr>
                </thead>
                <%
                    //                List<Object> datas = new CutiDAO().getAll();
                    List<Object> datas = (List<Object>) session.getAttribute("dataSetujuCutis");
                    int i = 1;
                    for (Object data : datas) {
                        SetujuCuti sc = (SetujuCuti) data;
                %>
                <tbody>
                    <tr>
                        <td><%= i++%></td>
                        <td><%= sc.getIdSetujuCuti()%></td>
                        <td><%= sc.getIdDetailCuti()%></td>
                        <td><%= sc.getStatus()%></td>
                        <td><%= sc.getIdJabatan().getJabatan()%></td>
                        <td>
                            <center><a class="btn btn-primary btn-xs" href="controllerPrintRecord?id=<%= sc.getIdSetujuCuti() %>" role="button" type="submit">Download</a><center>
                        </td>
                    </tr>
                </tbody>
                <%
                    }
                %>
            </table>
        </div>
    </body>
</html>
