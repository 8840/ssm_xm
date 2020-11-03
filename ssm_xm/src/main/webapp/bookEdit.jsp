<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <%--<script type="text/javascript">
        function doSubmit(bid){
            var bookForm = document.getElementById("bookForm");
            if(bid){
                //修改时候执行
                &lt;%&ndash;bookForm.action = '${pageContext.request.contextPath}/bookAction.action?methodName=update';&ndash;%&gt;
                bookForm.action = '${pageContext.request.contextPath}/book/edit';
            }else{
                //新增时候执行
                bookForm.action = '${pageContext.request.contextPath}/book/add';
            }
            bookForm.submit();
        }
    </script>--%>
</head>
<body>
<form id="bookForm" action="${pageContext.request.contextPath}${book2.bname==null ? '/book/add':'/book/edit'}" method="post">
    书籍ID:<input type="text" name="bid"  value="${book2.bid}"><br>
    书籍名称:<input type="text" name="bname" value="${book2.bname}"><br>
    书籍价格:<input type="text" name="price" value="${book2.price}"><br>
    <input type="submit"><br>
</form>
</body>
</html>