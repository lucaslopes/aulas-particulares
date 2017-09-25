// Para não deixar o corpo da página embaixo da barra fixa
$(window).ready(ajustaAltura())
$(window).resize(() => ajustaAltura())

function ajustaAltura() {
  let margem = $('nav').height()
  $('.corpo').css('margin-top', margem + 30)
}

// Para designar para as páginas 'aluno' e 'professor' a depender
// do chekbox selecionado no cadastro
$('#cadastrar').click(function() {
  event.preventDefault()

  if ($('#inlineRadio1').is(':checked'))
    window.location.href = "aluno.html"
  if ($('#inlineRadio2').is(':checked'))
    window.location.href = "professor.html"
})

// Ir para página inicial
$('#titulo').click(function() {
  window.location.href = "index.html"
})

// Selecionar os horários com o clique
$(".horario").click(function() {
  $(this).toggleClass('active')
})
