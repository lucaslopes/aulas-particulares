// Para não deixar o corpo da página embaixo da barra fixa
$(window).ready(setHeight())
$(window).resize(() => setHeight())

function setHeight() {
  let margem = $('nav').height()
  $('.corpo').css('margin-top', margem + 30)
}

// Selecionar os horários com o clique
$('.horario').click(function() {
  if (!$(this).hasClass('disabled'))
    $(this).toggleClass('active')
})

// Incluir nova matéria
$('#incluir').click(function() {
  event.preventDefault()

  if ($('#inputMateria').val() == '') {
    $('#inputMateria').addClass('is-invalid')
    return false
  }

  let horarioSelecionado

  $('.horario').each(function() {
    if ($(this).hasClass('active'))
      return horarioSelecionado = true
  })

  if (horarioSelecionado) {
    $('#alertIncluido').show().delay(3000).fadeOut()
    $('#inputMateria').val('')
    $('.horario').each(function() {
      if ($(this).hasClass('active'))
        $(this).removeClass('active')
    })
  } else
    $('#alertFaltaAula').show().delay(3000).fadeOut()
})

$('#inputMateria').keyup(function() {
  $('#inputMateria').removeClass('is-invalid')
})

$('#seletor').change(function() {
  $('.horario').each(function() {
    $(this).removeClass('active')
    $(this).addClass('disabled')
  })

  $('.horario').each(function() {
    let chance = Math.random()
    if (chance < .25) {
      $(this).toggleClass('disabled')
    }
  })
})

$('.horario').each(function() {
  console.log('ta aqui');
  if ($(this).hasClass('active')) {
    $('#agendar').show()
  }
})
// $('#agendar').hide()
// })
