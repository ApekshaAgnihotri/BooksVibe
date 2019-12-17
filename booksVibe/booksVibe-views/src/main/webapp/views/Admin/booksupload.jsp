<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="css/display.css">
</head>

<body>




	<center><h1>Books</h1></center>

	<table>

		<tr>

			<td>Book Id</td>

			<td>Book Title</td>

			<td>Author</td>

			<td>Category</td>

			<td>Publisher</td>

			<td>Language</td>

			<td>Copies</td>


						</tr>
						<s:iterator value="%{#session.booksDetailsList}">
							<tr>

								<td><s:property value="bookId"/></td>
								<td><s:property value="bookTitle" /></td>
								<td><s:property value="author" /></td>
								<td><s:property value="category" /></td>
								<td><s:property value="publisher" /></td>
								<td><s:property value="language" /></td>
								<td><s:property value="copies" /></td>
								<td><s:url var="updatepage" action="updatepage">
								 <s:param name="bookId" value="%{bookId}"></s:param>
								</s:url>
								<a href="<s:property value="#updatepage"/>">Edit</a>
								</td>

								<td><s:url action="deletebook" var="deletebook">
								<s:param name="bookId" value="%{bookId}"></s:param>
								</s:url> <a	href="<s:property value="#deletebook" />">Delete</a> <br />
								</td>
							</tr>
						</s:iterator>
					</table>

</body>
</html>
