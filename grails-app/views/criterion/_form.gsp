<%@ page import="ta.Criterion" %>



<div class="fieldcontain ${hasErrors(bean: criterionInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="criterion.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${criterionInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: criterionInstance, field: 'hab', 'error')} required">
	<label for="hab">
		<g:message code="criterion.hab.label" default="Habilidade Avaliada" />
		<span class="required-indicator">*</span>
		
	</label>
	<g:select name="hab" from="${criterionInstance.constraints.hab.inList}" required="" value="${criterionInstance?.hab}" valueMessagePrefix="criterion.hab"/>
</div>

