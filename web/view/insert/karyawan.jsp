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
        <script src="../js/bootstrap-timepicker.js"></script>
        <link rel="stylesheet" type="text/css" href="{{ asset('../css/style.css') }}">

        <!-- Bootstrap -->
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="../css/font-awesome.min.css">
        <link rel="stylesheet" href="../css/font-awesome.css">
        <link rel="stylesheet" href="../css/animate.css">
        <link rel="stylesheet" href="../css/timepicker.css">
        <link href="../css/style.css" rel="stylesheet" />
    </head>
    <body>
        <br><br>
    <center><h3><b>Form Data Karyawan</b></h3></center><br>
                <%
                    String autoid = (String) session.getAttribute("autoID");
                %>
    <div class="col-sm-12 col-sm-offset-3">
        <form action="karyawanI"> 
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="nik">NIK</label>
                    <input type="text" class="form-control" id="nik" name="txtNIK" value="<%= autoid%>" placeholder="NIK" readonly="true" />
                </div>
                <div class="form-group">
                    <label for="nama">Nama</label>
                    <input type="text" class="form-control" id="nama" name="txtNama" value="" placeholder="Nama" />
                </div>
                <div class="form-group">
                    <label for="alamat">Alamat</label>
                    <input type="text" class="form-control" id="alamat" name="txtAlamat" value="" placeholder="Alamat" />
                </div>
                <div class="form-group">
                    <label for="agama">Agama</label>
                    <input type="text" class="form-control" id="agama" name="txtAgama" value="" placeholder="Agama" />
                </div>
            </div>
            <div class="col-sm-3" style="margin-left: 30px;">
                <div class="form-group">
                    <label for="jenisKelamin">Jenis Kelamin</label>
                    <div class="radio">
                        <label><input type="radio" name="gender" value="Laki-Laki">Laki-Laki</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <label><input type="radio" name="gender" value="Perempuan">Perempuan</label>
                    </div>
                </div>
                <div class="form-group">
                    <div class='input-group date' id='datetimepicker1'>
                        <input type='text' class="form-control" />
                        <span class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar"></span>
                        </span>
                    </div>
                </div>
                <script type="text/javascript">
                    $(function () {
                        $('#datetimepicker1').datetimepicker();
                    });
                </script>
                <div class="form-group">
                    <label for="tanggalLahir">Tanggal Lahir</label>
                    <input type="date" class="form-control" id="tanggalLahir" name="txtTglLahir" value="" placeholder="Tanggal Lahir" />
                </div>
                <div class="form-group">
                    <label for="tanggalMulaiBekerja">Tanggal Mulai Bekerja</label>
                    <input type="date" class="form-control" id="tanggalMulaiBekerja" name="txtTglMulaiKerja" value="" placeholder="Tanggal Mulai Bekerja" />
                </div>
                <div class="form-group">
                    <label for="sisa">Sisa Cuti</label>
                    <input type="text" class="form-control" id="sisa" name="txtSisaCuti" value="" placeholder="Sisa Cuti" />
                </div>
                <input class="btn btn-primary" type="submit" value="Simpan" name="btnTambah"/><br><br><br>
            </div>
        </form>
    </div>

    <hr width="90%">    

    <br><center><h3><b>Data Karyawan</b></h3></center><br>
    <div class="col-lg-10 col-lg-offset-1">
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
                    <td><%= i++%></td>
                    <td><%= k.getNik()%></td>
                    <td><%= k.getNama()%></td>
                    <td><%= k.getAlamat()%></td>
                    <td><%= k.getAgama()%></td>
                    <td><%= k.getJenisKelamin()%></td>
                    <td><%= k.getTanggalLahir()%></td>
                    <td><%= k.getTglMulaiKerja()%></td>
                    <td><%= k.getSisa()%></td>
                    <td>
                        <a class="btn btn-primary btn-xs" href="karyawanU?id=<%= k.getNik()%>" role="button">Edit</a>
                        <a class="btn btn-danger btn-xs" href="karyawanD?id=<%= k.getNik()%>" role="button">Delete</a>                        
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
