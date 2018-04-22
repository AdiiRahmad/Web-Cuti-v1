<%-- 
    Document   : karyawan
    Created on : Apr 16, 2018, 11:51:31 AM
    Author     : Siti Khusnul Azifah
--%>

<%@page import="entities.Karyawan"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Karyawan</title>
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
        <br><center><h3><b>Data Karyawan</b></h3></center><br>
        <div class="col-lg-10 col-lg-offset-1">
            <a class="btn btn-primary" href="karyawanAutoID" role="button">Tambah Data</a><br><br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">No</th>
                        <th scope="col">NIK</th>
                        <th scope="col">Nama</th>
                        <th scope="col">Alamat</th>
                        <th scope="col">Agama</th>
                        <th scope="col">Jenis Kelamin</th>
                        <th scope="col">Tanggal Lahir</th>
                        <th scope="col">Tanggal Mulai Bekerja</th>
                        <th scope="col">Sisa Cuti</th>
                        <th scope="col">Aksi</th>
                    </tr>
                </thead>
                <%
    //                List<Object> datas = new CutiDAO().getAll();
                    List<Object> datas = (List<Object>) session.getAttribute("dataKaryawans");
                    int i = 1;
                    for (Object data : datas) {
                        Karyawan k = (Karyawan) data;
                %>
                <tbody>
                    <tr>
                        <td><%= i++ %></td>
                        <td><%= k.getNik() %></td>
                        <td><%= k.getNama() %></td>
                        <td><%= k.getAlamat() %></td>
                        <td><%= k.getAgama() %></td>
                        <td><%= k.getJenisKelamin() %></td>
                        <td><%= k.getTanggalLahir() %></td>
                        <td><%= k.getTglMulaiKerja() %></td>
                        <td><%= k.getSisa() %></td>
                        <td><center>
                            <a class="btn btn-primary btn-xs" href="karyawanU?id=<%= k.getNik() %>" role="button">Edit</a>
                            <a class="btn btn-danger btn-xs" href="karyawanD?id=<%= k.getNik() %>" role="button">Delete</a>                        
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
