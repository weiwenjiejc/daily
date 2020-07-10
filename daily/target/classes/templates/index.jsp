<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@page import="com.dareway.framework.util.SessionUtil"%>
<%@taglib uri="newform.tld" prefix="nf"%>
<%@taglib uri="newgrid.tld" prefix="ng"%>
<%@taglib uri="darewayBS.tld" prefix="dw"%>
<%@ taglib uri="segment.tld" prefix="seg"%>
<%@page import="com.dareway.apps.pspserver.ApplicationPara"%>
<%@page import="com.dareway.framework.util.CurrentUser"%>

<% 
	CurrentUser user = (CurrentUser) SessionUtil.getUser(request);
	String biz = (String) user.getValue("biz");
	String bljgid = (String) user.getValue("bljgid");
%>

<dw:body>
	<nf:form name="resultForm" colCount="6" marginRight="50"
		dataSource="servresult">
		<nf:formTitle value="服务信息" />
		<nf:textInput dataType="string" name="sermc" labelValue="服务名"
			readonly="true"></nf:textInput>
		<nf:textInput dataType="string" name="sermcchin" labelValue="服务中文名"
			readonly="true"></nf:textInput>
		<nf:textInput dataType="date" name="releasedate" labelValue="发布时间"
			<nf:textInput dataType="string" name="providerName" labelValue="提供方单位名称"
			readonly="true"></nf:textInput>
		<nf:dropdown name="purpose" labelValue="业务领域"
			code="YWLY" readonly="true"></nf:dropdown>
		<nf:textInput dataType="date" name="newlydate" labelValue="新增时间"
			mask="yyyy-MM-dd hh:mm:ss" readonly="true"></nf:textInput>
			mask="yyyy-MM-dd hh:mm:ss" readonly="true"></nf:textInput>
		<nf:multiLineText name="remarks" labelValue="服务描述" readonly="true"
			colspan="4" rowspan="2"></nf:multiLineText>
		<nf:buttons>
			<nf:button value="修改" onclick="btnModifiyService()"></nf:button>
			<nf:button value="注销" onclick="btnConcelService()"></nf:button>
			<nf:button value="发布" onclick="btnRelease()"></nf:button>
		</nf:buttons>
	</nf:form>

	<nf:form name="queryForm" colCount="6" marginRight="50">
		<nf:formTitle value="操作信息"></nf:formTitle>
		<nf:textInput dataType="string" name="opbh" labelValue="操作名"
			 colspan="2"></nf:textInput>
			 
		<nf:dropdown name="isactive" labelValue="状态"
			code="CZZT"></nf:dropdown>
			
			
			
			
			
			
			
		<!-- 新增 -->
		<nf:nextLine/>
		<nf:dropdown name="sharingMode" labelValue="共享方式" code="GXFS"></nf:dropdown>
		<nf:dropdown name="dataUpdateRate" labelValue="源数据更新频率" code="YSJGXPL"></nf:dropdown>
		<nf:dropdown name="dataRange" labelValue="数据范围" code="SJFW"></nf:dropdown>
			
			
			
		<nf:buttons align="right">
			<nf:button value="查询" name="btnQuery" onclick="qeryoperation()"></nf:button>
			<nf:button value="新增操作" name="btnAdd" onclick="btnAddServClicked()"></nf:button>
			<nf:button value="还原操作" name="btnReduce" onclick="btnReduceOperClicked()"></nf:button>
		</nf:buttons>
		
		
		
	</nf:form>
	<dw:hLayout>
		<dw:panel rightBorder="1000">
			<ng:grid name="operGrid" dataSource="operresult"
				onDblClickRow="btnModifiyOperation">
				<ng:gridColumns
				
				
					<ng:gridHyperlink name="operation" head="操作" bodyAlign="center"
						value="维护" href="btnModifiyOperation()"></ng:gridHyperlink>
				</ng:gridColumns>
			</ng:grid>
		</dw:panel>
					widthConfig="opbh:152,opbhchin:142,optype:113,istrade:152,isactive:72,instruction:222,operation:50">
					<ng:gridTextInput dataType="string" name="sermc" hidden="true"></ng:gridTextInput>
					<ng:gridTextInput dataType="string" name="opbh" head="操作名"></ng:gridTextInput>
					<ng:gridTextInput dataType="string" name="opbhchin" head="操作中文名"></ng:gridTextInput>
					<ng:gridDropdown name="optype" head="操作类型"
						code="CZLX"></ng:gridDropdown>
					<ng:gridDropdown name="isactive" head="状态"
						code="CZZT"
						width="60"></ng:gridDropdown>
					<ng:gridTextInput dataType="string" name="remarks" head="说明"></ng:gridTextInput>
		<dw:panel width="40"></dw:panel>
	</dw:hLayout>
</dw:body>

<script type="text/javascript">
//服务详情及操作信息界面界面
	//双击事件，进入操作详情界面
	function btnModifiyOperation() {
		var table = getObject("operGrid");
		var selectRow = table.getCurrentRow();
		if (selectRow == null) {
			alert("没有选中行！！！");
			return;
		}

		var opbh = table.getCellValue(selectRow, "opbh");
		var sermc = getObject("sermc").getValue();
		var opbhchin = table.getCellValue(selectRow, "opbhchin");
		
		var servdockBar = getParentSheet().getParentSheet().getObject("servicesmenubar");
		var item = servdockBar.getBarItem(sermc+opbh);
		if (item == null) {
			servdockBar.addBarItem(sermc+opbh, sermc + "." + opbh + "("+ opbhchin + ")",
					"services.do?method=fwdServiceMod&opbh=" + opbh + "&sermc="
							+ sermc, null, null, true);
		}
		servdockBar.selectBarItem(sermc+opbh);
	}

	//新增操作
	function btnAddServClicked() {
		var sermc = getObject("sermc").getValue();
		var para = {
			"biz" : <%=biz%>,
			"bljgid" : <%=bljgid%>,
			"sermc" : sermc
		};
		doNewProcess("dwpspXzcz", para);
	}

	//查询操作信息
	function qeryoperation() {
		url = new URL("services.do?method=queryOperation");
		url.addForm("queryForm");//得到form中的内容
		url.addForm("resultForm");
		urlString = url.getURLString();
		asynchFillData(urlString, "operGrid:result");//将查询的结果显示到页面上
	}
	
	//修改服务
	function btnModifiyService() { 
		var sermc = getObject("sermc").getValue();
		var para = {
			"biz" : <%=biz%>,
			"bljgid" : <%=bljgid%>,
			"sermc" : sermc
		};
		doNewProcess("dwpspXgfw", para);
	}

	//注销服务
	function btnConcelService() { 
		var sermc = getObject("sermc").getValue();
		var para = {
			"biz" : <%=biz%>,
			"bljgid" : <%=bljgid%>,
			"sermc" : sermc
		};
		doNewProcess("dwpspZxfw", para);
	}

	//发布服务
	function btnRelease() { 
		var sermc = getObject("sermc").getValue();
		var para = {
			"biz" : <%=biz%>,
			"bljgid" : <%=bljgid%>,
			"sermc" : sermc
		};
		doNewProcess("dwpspFbfw", para);
	}
	//还原操作
	function btnReduceOperClicked(){
		var url = new URL("services.do?method=reduceOperation");
		url.addForm("resultForm");//得到form中的内容
		openRES("已注销的操作", url.getURLString(), 1000, 600);
	}
</script>