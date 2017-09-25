// Para não deixar o corpo da página embaixo da barra fixa
$(window).ready(() => ajustaAltura())
$(window).resize(() => ajustaAltura())

function ajustaAltura() {
  let margem = $('nav').height()
  $('.corpo').css('margin-top', margem + 30)
}

// Para designar para as páginas 'aluno' e 'professor' a depender
// do chekbox selecionado no cadastro (não está funcionando)
$('#cadastrar').click(() => {
  event.preventDefault()
  if ($('#inlineRadio1:checked'))
    window.location.href = "aluno.html"
  else if ($('#inlineRadio2:checked'))
    window.location.href = "professor.html"
})

// Tentativa de selecionar os horários com o clique
$('.horario').click(() => $(this).toggleClass('active'))
