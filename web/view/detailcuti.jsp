<%-- 
    Document   : pengajuancuti
    Created on : Apr 16, 2018, 4:36:39 PM
    Author     : Siti Khusnul Azifah
--%>

<%@page import="java.util.List"%>
<%@page import="entities.DetailCuti"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <title>Pengajuan Cuti</title>
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
        <br><center><h3><b>Laporan Pengajuan Cuti</b></h3></center><br>
        <div class="col-lg-10 col-lg-offset-1">
            <a class="btn btn-primary" href="detailCutiAutoID" role="button">Tambah Data</a><br><br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">No</th>
                        <th scope="col">ID Detail Cuti</th>
                        <th scope="col">NIK</th>
                        <th scope="col">Jenis Cuti</th>
                        <th scope="col">Keterangan</th>
                        <th scope="col">Tanggal Mulai</th>
                        <th scope="col">Tanggal Selesai</th>
                        <th scope="col">Lama Cuti</th>
                        <th scope="col">Aksi</th>
                    </tr>
                </thead>
                <%
    //                List<Object> datas = new CutiDAO().getAll();
                    List<Object> datas = (List<Object>) session.getAttribute("dataDetailCutis");
                    int i = 1;
                    for (Object data : datas) {
                        DetailCuti dc = (DetailCuti) data;
                %>
                <tbody>
                    <tr>
                        <td><%= i++ %></td>
                        <td><%= dc.getIdDetailCuti() %></td>
                        <td><%= dc.getNik() %></td>
                        <td><%= dc.getIdCuti().getJenisCuti() %></td>
                        <td><%= dc.getKeterangan() %></td>
                        <td><%= dc.getTanggalMulai() %></td>
                        <td><%= dc.getTanggalSelesai() %></td>
                        <td><%= dc.getLamaCuti() %></td>
                        <td><center>
                            <a class="btn btn-primary btn-xs" href="detailCutiU?id=<%= dc.getIdDetailCuti() %>" role="button">Edit</a>
                            <a class="btn btn-danger btn-xs" href="detailCutiD?id=<%= dc.getIdDetailCuti() %>" role="button">Delete</a>
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
