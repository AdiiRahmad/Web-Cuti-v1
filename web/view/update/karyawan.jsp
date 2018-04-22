<%-- 
    Document   : karyawan
    Created on : Apr 16, 2018, 11:51:31 AM
    Author     : Siti Khusnul Azifah
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
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
        <br><br>
    <center><h3><b>Form Data Karyawan</b></h3></center><br>
    <div class="col-sm-12 col-sm-offset-3">
        <form action="prosesUpdateKaryawan">
            <%
                Object datas = session.getAttribute("karyawanU");
                Karyawan k = (Karyawan) datas;

                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String tanggallahir = dateFormat.format(k.getTanggalLahir());
                String tanggalmulai = dateFormat.format(k.getTglMulaiKerja());
            %>  
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="nik">NIK</label>
                    <input type="text" class="form-control" id="nik" placeholder="NIK" name="txtNIK" value="<%= k.getNik()%>" readonly="true" />
                </div>
                <div class="form-group">
                    <label for="nama">Nama</label>
                    <input type="text" class="form-control" id="nama" placeholder="Nama" name="txtNama" value="<%= k.getNama()%>"" />
                </div>
                <div class="form-group">
                    <label for="alamat">Alamat</label>
                    <input type="text" class="form-control" id="alamat" placeholder="Alamat" name="txtAlamat" value="<%= k.getAlamat()%>" />
                </div>
                <div class="form-group">
                    <label for="agama">Agama</label>
                    <input type="text" class="form-control" id="agama" placeholder="Agama" name="txtAgama" value="<%= k.getAgama()%>" />
                </div>
            </div>
            <div class="col-sm-3" style="margin-left: 30px;">
                <div class="form-group">
                    <label for="jenisKelamin">Jenis Kelamin</label>
                    <div class="radio">
                        <%
                            if (k.getJenisKelamin().equals("Laki-Laki")) {
                        %>
                        <label><input type="radio" name="gender" value="Laki-Laki" checked="checked">Laki-laki</label> &nbsp;&nbsp;&nbsp;&nbsp;
                        <label><input type="radio" name="gender" value="Perempuan"> Perempuan</label>
                            <% } else { %>
                        <label><input type="radio" name="gender" value="Laki-Laki"> Laki-laki</label>&nbsp;&nbsp;&nbsp;&nbsp;
                        <label><input type="radio" name="gender" value="Perempuan" checked="checked"> Perempuan</label>
                            <%
                                }
                            %>
                    </div>
                </div>
                <div class="form-group">
                    <label for="tanggalLahir">Tanggal Lahir</label>
                    <input type="date" class="form-control" id="tanggalLahir" placeholder="Tanggal Lahir" name="txtTglLahir" value="<%= tanggallahir %>" />
                </div>
                <div class="form-group">
                    <label for="tanggalMulaiBekerja">Tanggal Mulai Bekerja</label>
                    <input type="date" class="form-control" id="tanggalMulaiBekerja" placeholder="Tanggal Mulai Bekerja" name="txtTglMulaiKerja" value="<%= tanggalmulai %>" />
                </div>
                <div class="form-group">
                    <label for="sisa">Sisa Cuti</label>
                    <input type="text" class="form-control" id="sisa" placeholder="Sisa Cuti" name="txtSisaCuti" value="<%= k.getSisa()%>" />
                </div>
                <div class="form-group">
                    <input class="btn btn-primary" href="karyawanController" type="submit" value="Update" name =" btnUpdate"/>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
