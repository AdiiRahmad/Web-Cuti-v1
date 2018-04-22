<%-- 
    Document   : pengajuancuti
    Created on : Apr 16, 2018, 4:36:39 PM
    Author     : Siti Khusnul Azifah
--%>

<%@page import="entities.Cuti"%>
<%@page import="entities.Karyawan"%>
<%@page import="java.util.List"%>
<%@page import="entities.DetailCuti"%>
<%@page import="dao.DetailCutiDAO"%>
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
        <br><br>
    <center><h3><b>Form Pengajuan Cuti</b></h3></center><br>
    <div class="col-sm-12 col-sm-offset-4">
        <%
            String autoid = (String) session.getAttribute("autoID");
            List<Object> datas1 = (List<Object>) session.
                    getAttribute("KaryawanList");

            List<Object> datas2 = (List<Object>) session.
                    getAttribute("CutiList");
        %>
        <form action="detailCutiI">
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="idDetailCuti">ID Detail Cuti</label>
                    <% if (autoid.equals("D")) {
                    %><input type="text" class="form-control" id="idDetailCuti" name="txtIDDetailCuti" value="<%= autoid%>001" placeholder="ID Detail Cuti" readonly="true" /><%
                } else {%>
                    <input type="text" class="form-control" id="idDetailCuti" name="txtIDDetailCuti" value="<%= autoid%>" placeholder="ID Detail Cuti" readonly="true" />
                    <%}%>

                </div>
                <div class="form-group">
                    <label for="nik">NIK</label>
                    <select name="txtNik"  class="form-control">
                        <% for (Object data : datas1) {
                                Karyawan k = (Karyawan) data;
                        %>
                        <option value="<%= k.getNik()%>"><%=k.getNik() + " - " + k.getNama()%></option> 
                        <%}
                        %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="jenisCuti">Jenis Cuti</label>
                    <select name="txtJenisCuti"  class="form-control">
                        <% for (Object data : datas2) {
                                Cuti cu = (Cuti) data;
                        %>
                        <option value="<%= cu.getIdCuti()%>"><%=cu.getIdCuti() + " - " + cu.getJenisCuti()%></option> 
                        <%}
                        %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="keterangan">Keterangan</label>
                    <input type="text" class="form-control" id="keterangan" name="txtKeteranganCuti" value="" placeholder="Keterangan" />
                </div>
                <div class="form-group">
                    <label for="tanggalMulai">Tanggal Mulai</label>
                    <input type="date" class="form-control" id="tanggalMulai" name="txtTanggalMulai" value="" placeholder="Tanggal Mulai" />
                </div>
                <div class="form-group">
                    <label for="tanggalSelesai">Tanggal Selesai</label>
                    <input type="date" class="form-control" id="tanggalSelesai" name="txtTanggalSelesai" value="" placeholder="Tanggal Selesai" />
                </div>
                <!--                <div class="form-group">
                                    <label for="lamaCuti">Lama Cuti</label>
                                    <input type="text" class="form-control" id="lamaCuti" name="txtLamaCuti" value="" placeholder="Lama Cuti" />
                                </div>-->
                <input class="btn btn-primary" type="submit" value="Simpan" name="btnTambah"/>
            </div>
        </form>
    </div>
</body>
</html>
