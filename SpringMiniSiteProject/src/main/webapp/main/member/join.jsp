<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="shadow/css/shadowbox.css">
<link rel="stylesheet" type="text/css" href="style/table.css">
<script src="http://code.jquery.com/jquery.js"></script>
<script src="shadow/js/shadowbox.js"></script>
<script>
Shadowbox.init({
	players:['iframe']
});
$(function(){
	$('#postBtn').click(function(){
		Shadowbox.open({
			content:"postfind.do",player:'iframe',title:'�����ȣ �˻�(����)',width:450,height:400
		});
	});
});
</script>
</head>
<body>
	<center>
		<h3>ȸ������</h3>
		<form method=post action="join_ok.do" name="join_frm">
		<table border=1 width=500 cellpadding=0 cellspacing=0 bordercolor=black>
			<tr>
				<td>
				<table id=table_content width=500>
				<tr>
				<th width=20% align=right>ID</th>
				<td width=80% align=left>
					<input type=text name=id size=12 required>
					<input type=button value="ID�ߺ� üũ" id="idcheckBtn">
				</td>
				</tr>
				<tr>
				<th width=20% align=right>��й�ȣ</th>
				<td width=80% align=left>
					<input type=password name=pwd size=12 required>&nbsp; ���Է�
					<input type=password name=pwd2 size=12 required>
				</td>
				</tr>
				<tr>
				<th width=20% align=right>�̸�</th>
				<td width=80% align=left>
					<input type=text name=name size=12 required>
				</td>
				</tr>
				<tr>
				<th width=20% align=right>����</th>
				<td width=80% align=left>
					<input type=radio name=sex value=���� checked>����
					<input type=radio name=sex value=����>����
				</td>
				</tr>
				<tr>
				<th width=20% align=right>�������</th>
				<td width=80% align=left>
					<input type=date name=bday size=20>
				</td>
				</tr>
				<tr>
				<th width=20% align=right>�̸���</th>
				<td width=80% align=left>
					<input type=text name=email size=50 required>
				</td>
				</tr>
				<tr>
				<th width=20% align=right>�����ȣ</th>
				<td width=80% align=left>
					<input type=text name=post1 size=7 readonly>-
					<input type=text name=post2 size=7 readonly>
					<input type=button value="�����ȣ�˻�" id="postBtn">
				</td>
				</tr>
				<tr>
				<th width=20% align=right>�ּ�</th>
				<td width=80% align=left>
					<input type=text name=addr1 size=50 required>
				</td>
				</tr>
				<tr>
				<th width=20% align=right>���ּ�</th>
				<td width=80% align=left>
					<input type=text name=addr2 size=50>
				</td>
				</tr>
				<tr>
				<th width=20% align=right>��ȭ��ȣ</th>
				<td width=80% align=left>
					<select name=tel1>
					<option>010</option>
					<option>011</option>
					<option>017</option>
					</select>
					<input type=text name=tel2 size=20>
				</td>
				</tr>
				<tr>
				<td colspan=2 align=center>
					<input type=submit value=����>
					<input type=button value=��� onclick="javascript:history.back()">
				</td>
				</tr>
				</table>
				</td>
			</tr>
		</table>
		</form>
	</center>
	
</body>
</html>