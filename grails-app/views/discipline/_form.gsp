<%@ page import="ta.Discipline" %>



<div class="fieldcontain ${hasErrors(bean: disciplineInstance, field: 'discipline', 'error')} required">
	<label for="discipline">
		<g:message code="discipline.discipline.label" default="Discipline" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="discipline" required="" value="${disciplineInstance?.discipline}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: disciplineInstance, field: 'classTime', 'error')} required">
	<label for="classTime">
		<g:message code="discipline.classTime.label" default="Class Time" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="classTime" precision="day"  value="${disciplineInstance?.classTime}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: disciplineInstance, field: 'professor', 'error')} required">
	<label for="professor">
		<g:message code="discipline.professor.label" default="Professor" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="professor" required="" value="${disciplineInstance?.professor}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: disciplineInstance, field: 'students', 'error')} ">
	<label for="students">
		<g:message code="discipline.students.label" default="Students" />
		
	</label>
	<g:select name="students" from="${ta.Student.list()}" multiple="multiple" optionKey="id" size="5" value="${disciplineInstance?.students*.id}" class="many-to-many"/>

</div>

