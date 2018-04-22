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
        <br><br>
        <center><h3><b>Form Data Jabatan</b></h3></center><br>
        <div class="col-sm-12 col-sm-offset-4">
            <form action="prosesUpdateJabatan">
                <%
                    Object datas =  session.getAttribute("jabatanU");
                    Jabatan j = (Jabatan) datas;
                %> 
                <div class="col-sm-3">
                    <div class="form-group">
                        <label for="idJabatan">ID Jabatan</label>
                        <input type="text" class="form-control" id="idJabatan" placeholder="ID Jabatan" name="txtIDJabatan" value="<%= j.getIdJabatan() %>" readonly="true" />
                    </div>
                    <div class="form-group">
                        <label for="jabatan">Jabatan</label>
                        <input type="text" class="form-control" id="jabatan" placeholder="Jabatan" name="txtJabatan" value="<%= j.getJabatan() %>" />
                    </div>
                    <div class="form-group">
                        <label for="idPimpinan">ID Pimpinan</label>
                        <input type="text" class="form-control" id="idPimpinan" placeholder="ID Pimpinan" name="txtIDPimpinan" value="<%= j.getIdPimpinan() %>" />
                    </div>
                    <div class="form-group">
                        <input class="btn btn-primary" href="jabatanController" type="submit" value="Update" name =" btnUpdate"/>
                    </div>
                </div>
            </form>
        </div>
            </table>
        </div>
    </body>
</html>
