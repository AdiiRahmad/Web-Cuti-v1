<%-- 
    Document   : pengajuancuti
    Created on : Apr 16, 2018, 4:36:39 PM
    Author     : Siti Khusnul Azifah
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entities.Karyawan"%>
<%@page import="entities.Cuti"%>
<%@page import="java.lang.Object"%>
<%@page import="entities.DetailCuti"%>
<%@page import="java.util.List"%>
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
        <form action="prosesUpdateDetailCuti">
            <%
                Object datas = session.getAttribute("detailCutiU");
                DetailCuti dc = (DetailCuti) datas;

                List<Object> datas1 = (List<Object>) session.
                        getAttribute("KaryawanList");
                
                List<Object> datas2 = (List<Object>) session.
                        getAttribute("CutiList");
                
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String tanggalmulai = dateFormat.format(dc.getTanggalMulai());
                String tanggalselesai = dateFormat.format(dc.getTanggalSelesai());

                Date tglmulai = dc.getTanggalMulai();
                Date tglselesai = dc.getTanggalSelesai();

                Long mulai = tglmulai.getTime();
                Long selesai = tglselesai.getTime();
                Long Selisih = selesai - mulai;
                Long lamaCuti = Selisih / (24 * 60 * 60 * 1000) + 1;

            %> 
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="idDetailCuti">ID Detail Cuti</label>
                    <input type="text" class="form-control" id="idDetailCuti" name="txtIDDetailCuti" value="<%= dc.getIdDetailCuti()%>" placeholder="ID Detail Cuti" readonly="true" />
                </div>
                <div class="form-group">
                    <label for="nik">NIK</label>
                    <select name="txtNik"  class="form-control">
                        <% for (Object data : datas1) {
                                Karyawan k = (Karyawan) data;
                                if (k.getNik().equals(dc.getNik().getNik())) {
                        %>
                                    <option value="<%= k.getNik()%>" selected><%=k.getNik() + " - " + k.getNama()%></option> 
                        <%      } else {%>
                                    <option value="<%= k.getNik()%>"><%=k.getNik() + " - " + k.getNama()%></option> 
                        <%      }
                            }
                        %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="jenisCuti">Jenis Cuti</label>
                    <select name="txtJenisCuti"  class="form-control">
                        <% for (Object data : datas2) {
                                Cuti cu = (Cuti) data;
                                if (cu.getIdCuti().equals(dc.getIdCuti().getIdCuti())) {
                        %>
                                    <option value="<%= cu.getIdCuti()%>" selected><%=cu.getIdCuti() + " - " + cu.getJenisCuti()%></option> 
                        <%      } else {%>
                                    <option value="<%= cu.getIdCuti()%>"><%=cu.getIdCuti() + " - " + cu.getJenisCuti()%></option> 
                        <%      }
                            }
                        %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="keterangan">Keterangan</label>
                    <input type="text" class="form-control" id="keterangan" name="txtKeteranganCuti" value="<%= dc.getKeterangan()%>" placeholder="Keterangan" />
                </div>
                <div class="form-group">
                    <label for="tanggalMulai">Tanggal Mulai</label>
                    <input type="date" class="form-control" id="tanggalMulai" name="txtTanggalMulai" value="<%= tanggalmulai %>" placeholder="Tanggal Mulai" />
                </div>
                <div class="form-group">
                    <label for="tanggalSelesai">Tanggal Selesai</label>
                    <input type="date" class="form-control" id="tanggalSelesai" name="txtTanggalSelesai" value="<%= tanggalselesai %>" placeholder="Tanggal Selesai" />
                </div>
                <div class="form-group">
                    <label for="lamaCuti">Lama Cuti</label>
                    <input type="text" class="form-control" id="lamaCuti" name="txtLamaCuti" value="<%= dc.getLamaCuti()%>" placeholder="Lama Cuti" />
                </div>
                <div class="form-group">
                    <input class="btn btn-primary" href="detailCutiController" type="submit" value="Update" name =" btnUpdate"/>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
