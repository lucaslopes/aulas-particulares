// Ao clicar no título, ir para página principal
$('#titulo').click(function() {
  window.location.href = "index.html"
})

// Ao clicar em 'cadastro', ir para 'aluno' ou 'professor'
$('#cadastrar').click(function() {
  event.preventDefault()
  if (validaCadastro())
    goTo()
})

// Ao clicar em 'login', ir para 'aluno' ou 'professor'
$('#login').click(function() {
  event.preventDefault()
  if (validaLogin())
    goTo()
})

// Para designar para as páginas 'aluno' e 'professor'
function goTo() {
  if ($('#opcaoAluno').is(':checked'))
    window.location.href = "aluno.html"
  if ($('#opcaoProfessor').is(':checked'))
    window.location.href = "professor.html"
}
