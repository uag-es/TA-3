<%@ page import="ta.Student" %>



<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="student.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${studentInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'login', 'error')} required">
	<label for="login">
		<g:message code="student.login.label" default="Login" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="login" required="" value="${studentInstance?.login}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: disciplineInstance, field: 'disciplines', 'error')} ">
	<label for="disciplines">
		<g:message code="students.discipline.label" default="Disciplines" />
		
	</label>
	<g:select name="disciplines" from="${ta.Discipline.list()}" multiple="multiple" optionKey="id" size="5" value="${disciplineInstance?.disciplines*.id}" class="many-to-many"/>

</div>


