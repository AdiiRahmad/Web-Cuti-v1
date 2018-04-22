<%-- 
    Document   : persetujuancuti
    Created on : Apr 16, 2018, 4:37:14 PM
    Author     : Siti Khusnul Azifah
--%>

<%@page import="entities.Jabatan"%>
<%@page import="entities.DetailCuti"%>
<%@page import="entities.SetujuCuti"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <html>
        <head>
            <title>Persetujuan Cuti</title>
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
        <center><h3><b>Form Persetujuan Cuti</b></h3></center><br>
        <div class="col-sm-12 col-sm-offset-4">
            <form action="prosesUpdateSetujuCuti">
                <%
                    Object datas = session.getAttribute("setujuCutiU");
                    SetujuCuti sc = (SetujuCuti) datas;

                    List<Object> datas1 = (List<Object>) session.
                            getAttribute("DetailCutiList");

                    List<Object> datas2 = (List<Object>) session.
                            getAttribute("JabatanList");
                %>  
                <div class="col-sm-3">
                    <div class="form-group">
                        <label for="idSetujuCuti">ID Setuju Cuti</label>
                        <input type="text" class="form-control" id="idSetujuCuti" placeholder="ID Setuju Cuti" name="txtIDSetujuCuti" value="<%= sc.getIdSetujuCuti()%>" readonly="true" />
                    </div>
                    <div class="form-group">
                        <label for="idDetailCuti">ID Detail Cuti</label>
                        <select name="txtIDDetailCuti"  class="form-control">
                            <% for (Object data : datas1) {
                                    DetailCuti dc = (DetailCuti) data;
                                    if (dc.getIdDetailCuti().equals(sc.getIdDetailCuti().getIdDetailCuti())) {
                            %>
                            <option value="<%= dc.getIdDetailCuti() %>" selected><%= dc.getIdDetailCuti() + " - " + dc.getNik().getNama() %></option> 
                            <%      } else {%>
                            <option value="<%= dc.getIdDetailCuti() %>"><%= dc.getIdDetailCuti() + " - " + dc.getNik().getNama() %></option> 
                            <%      }
                                }
                            %>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="status">Status</label>
                        <select name="txtStatus"  class="form-control">
                            <option value="Diterima" selected>Diterima</option> 
                            <option value="Ditolak">Ditolak</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="idJabatan">ID Jabatan</label>
                        <select name="txtIDJabatan"  class="form-control">
                            <% for (Object data : datas2) {
                                    Jabatan j = (Jabatan) data;
                                    if (j.getIdJabatan().equals(sc.getIdJabatan().getIdJabatan())) {
                            %>
                            <option value="<%= j.getIdJabatan() %>" selected><%= j.getIdJabatan() + " - " + j.getJabatan() %></option> 
                            <%      } else {%>
                            <option value="<%= j.getIdJabatan() %>"><%= j.getIdJabatan() + " - " + j.getJabatan() %></option> 
                            <%      }
                                }
                            %>
                        </select>
                    </div>
                    <div class="form-group">
                        <input class="btn btn-primary" href="setujuCutiController" type="submit" value="Update" name =" btnUpdate"/>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
