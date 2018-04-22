<%-- 
    Document   : cuti
    Created on : Apr 16, 2018, 4:35:24 PM
    Author     : Siti Khusnul Azifah
--%>

<%@page import="java.util.List"%>
<%@page import="entities.Cuti"%>
<%@page import="dao.CutiDAO"%>
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
        <br><br>
        <center><h3><b>Form Data Cuti</b></h3></center><br> 
        <div class="col-sm-12 col-sm-offset-4">
            <%
                String autoid = (String) session.getAttribute("autoID");
            %>
            <form action="cutiI">
                <div class="col-sm-3">
                    <div class="form-group">
                        <label for="idCuti">ID Cuti</label>
                        <input type="text" class="form-control" id="idCuti" name="txtIDCuti" placeholder="ID Cuti" value="<%= autoid%>" readonly="true" />
                    </div>
                    <div class="form-group">
                        <label for="jenisCuti">Jenis Cuti</label>
                        <input type="text" class="form-control" id="jenisCuti" name="txtJenisCuti" placeholder="Jenis Cuti" value="" />
                    </div>
                    <div class="form-group">
                        <label for="durasiCuti">Durasi Cuti</label>
                        <input type="text" class="form-control" id="durasiCuti" name="txtDurasiCuti" placeholder="Durasi Cuti" value="" />
                    </div>
                    <div class="form-group">
                        <label for="keterangan">Keterangan</label>
                        <input type="text" class="form-control" id="keterangan" name="txtKeteranganCuti" placeholder="Keterangan" value="" />
                    </div>
                    <input class="btn btn-primary" type="submit" value="Simpan" name="btnTambah"/>
                </div>
            </form>
        </div>
    </body>
</html>
