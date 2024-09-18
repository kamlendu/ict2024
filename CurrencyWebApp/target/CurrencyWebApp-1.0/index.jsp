<%@ page import=" java.math.BigDecimal, ejb.ConverterRemote, javax.naming.InitialContext"%>

<%!
	
        
	ConverterRemote converter = null;

	public void jspInit()
	{
		try
		{
                    
	InitialContext ic = new InitialContext();
	converter = (ConverterRemote) ic.lookup("ejb/Converter");
		}
		catch (Exception ex)
		{
			System.out.println("Could not create currency converter stateless session bean."+ ex.getMessage());
		}
	}

	public void jspDestroy()
	{
		converter = null;
	}
%>

<HTML>
	<HEAD>
		<TITLE>Currency Converter</TITLE>
	</HEAD>



	<BODY BGCOLOR="pink">
		<H1>Currency Converter in 4 easy steps</H1>
		<HR>
		<P>Enter an amount to convert:</P>
		<FORM METHOD="POST">
			<TABLE WIDTH="100%" BORDER="0" CELLSPACING="0" CELLPADDING="0">
				<TR>
					<TD WIDTH="5%" ALIGN="center"><H1>1</H1></TD>
					<TD> Convert: <BR />
						<INPUT TYPE="text" NAME="amount" VALUE="1" SIZE="10" TABINDEX="1" />
						<DIV>Enter an amount</DIV>
					</TD>
				</TR>
				<TR>
					<TD WIDTH="5%" ALIGN="center"><H1>2</H1></TD>
					<TD>
						From this currency:<BR />
						<SELECT NAME="From" SIZE="3" TABINDEX="2">
							<OPTION VALUE="USD">America (United States), Dollar (USD)</OPTION>
							<OPTION VALUE="INR">India, Rupee (INR)</OPTION>
						</SELECT>
					</TD>
				</TR>
				<TR>
					<TD WIDTH="5%" ALIGN="center"><H1>3</H1></TD>
					<TD>
						To this currency:<BR />
						<SELECT NAME="To" SIZE="3" TABINDEX="3">
							<OPTION VALUE="USD">America (United States), Dollar (USD)</OPTION>
							<OPTION VALUE="INR">India, Rupee (INR)</OPTION>
						</SELECT>
					</TD>
				</TR>
				<TR>
					<TD WIDTH="5%" ALIGN="center" CLASS="title"><H1>4</H1></TD>
					<TD><INPUT NAME="cmdSubmit" TYPE="submit" VALUE="Submit" ALT="Convert" TABINDEX="4" /></TD>
				</TR>
			</TABLE>
		</FORM>
		<%
			String amount = request.getParameter("amount");
			if ( amount != null && amount.length() > 0 )
			{
 				double d = Double.parseDouble(amount);
                                double convertedAmount = converter.convert(request.getParameter("From"), request.getParameter("To"), d);
		%>
				<HR>
				<%= amount %>  <%= request.getParameter("From")%> = <%= convertedAmount %>  <%= request.getParameter("To")%>
		<%
			}
		%>
	</BODY>
</HTML>
