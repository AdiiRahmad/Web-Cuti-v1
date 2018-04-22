<%-- 
    Document   : cuti
    Created on : Apr 16, 2018, 4:35:24 PM
    Author     : Siti Khusnul Azifah
--%>

<%@page import="java.lang.Object"%>
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
        <br><br>
        <center><h3><b>Form Data Cuti</b></h3></center><br> 
        <div class="col-sm-12 col-sm-offset-4">
            <form action="prosesUpdateCuti">
                <%

                    Object datas =  session.
                            getAttribute("cutiU");
//                    int i = 1;
//                    for (Object data : datas) {
                        Cuti c = (Cuti) datas;
                %> 
                <div class="col-sm-3">
                    <div class="form-group">
                        <label for="idCuti">ID Cuti</label>
                        <input type="text" class="form-control" id="idCuti" name="txtIDCuti" value="<%= c.getIdCuti() %>" placeholder="ID Cuti" readonly="true" />
                    </div>
                    <div class="form-group">
                        <label for="jenisCuti">Jenis Cuti</label>
                        <input type="text" class="form-control" id="jenisCuti" name="txtJenisCuti" value="<%= c.getJenisCuti() %>" placeholder="Jenis Cuti" />
                    </div>
                    <div class="form-group">
                        <label for="durasiCuti">Durasi Cuti</label>
                        <input type="text" class="form-control" id="durasiCuti" name="txtDurasiCuti" value="<%= c.getDurasi() %>" placeholder="Durasi Cuti" />
                    </div>
                    <div class="form-group">
                        <label for="keterangan">Keterangan</label>
                        <input type="text" class="form-control" id="keterangan" name="txtKeteranganCuti" value="<%= c.getKeterangan() %>" placeholder="Keterangan" />
                    </div>
                    <div class="form-group">
                        <input class="btn btn-primary" href="cutiController" type="submit" value="Update" name =" btnUpdate"/>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
