let emailRegex = /^[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}$/
let nomeRegex = /^[a-z ,.'-]+$/i
let passwordRegex = /^[a-z0-9_-]{6,18}$/

// Login
function validaLogin() {
  if (!camposVaziosLogin() &&
      emailRegex.test($('#emailLogin').val()))
      return true
  else
    return false
}

$('#emailLogin').focusout(function() {
  if (!emailRegex.test($(this).val()) && $(this).val() != '') {
    $(this).addClass('is-invalid')
    $('#emailInvalido').show().delay(3000).fadeOut()
  }
})

function camposVaziosLogin() {
  let emailLogin = $('#emailLogin').val()
  let senhaLogin = $('#senhaLogin').val()

  if (emailLogin == '' || senhaLogin == '') {
    if (emailLogin == '')
      $('#emailLogin').addClass('is-invalid')

    if (senhaLogin == '')
      $('#senhaLogin').addClass('is-invalid')

    return true
  }
  return false
}

$('#emailLogin').keyup(function() {
  $(this).removeClass('is-invalid')
})

$('#senhaLogin').keyup(function() {
  $(this).removeClass('is-invalid')
})

// Cadastro
function validaCadastro() {
  if (!camposVaziosCadastro() &&
      emailRegex.test($('#emailCadastro').val()) &&
      nomeRegex.test($('#nomeCadastro').val()) &&
      passwordRegex.test($('#senhaConfirmacao').val()) &&
      $('#senhaConfirmacao').val() == $('#senhaCadastro').val())
      return true
  else
    return false
}

$('#nomeCadastro').focusout(function() {
  if (!nomeRegex.test($(this).val()) && $(this).val() != '') {
    $(this).addClass('is-invalid')
    $('#nomeInvalido').show().delay(3000).fadeOut()
  }
})

$('#emailCadastro').focusout(function() {
  if (!emailRegex.test($(this).val()) && $(this).val() != '') {
    $(this).addClass('is-invalid')
    $('#nomeInvalido').show().delay(3000).fadeOut()
  }
})

$('#senhaCadastro').focusout(function() {
  if (!passwordRegex.test($(this).val()) && $(this).val() != '') {
    $(this).addClass('is-invalid')
    $('#senhaInvalido').show().delay(3000).fadeOut()
  }
})

function camposVaziosCadastro() {
  let nomeCadastro = $('#nomeCadastro').val()
  let emailCadastro = $('#emailCadastro').val()
  let senhaCadastro = $('#senhaCadastro').val()
  let senhaConfirmacao = $('#senhaConfirmacao').val()
  let checkbox = $('#opcaoAluno').is(':checked') || $('#opcaoProfessor').is(':checked')

  if (nomeCadastro == '' ||
      emailCadastro == '' ||
      senhaCadastro == '' ||
      senhaConfirmacao == '' ||
      checkbox == false)
  {
      if (nomeCadastro == '')
        $('#nomeCadastro').addClass('is-invalid')

      if (emailCadastro == '')
        $('#emailCadastro').addClass('is-invalid')

      if (senhaCadastro == '')
        $('#senhaCadastro').addClass('is-invalid')

      if (senhaConfirmacao == '')
        $('#senhaConfirmacao').addClass('is-invalid')

      if (checkbox == false)
        $('#selecioneOpcao').show().delay(3000).fadeOut()

      return true
  }
  return false
}

$('#nomeCadastro').keyup(function() {
  $(this).removeClass('is-invalid')
})

$('#emailCadastro').keyup(function() {
  $(this).removeClass('is-invalid')
})

$('#senhaCadastro').keyup(function() {
  $(this).removeClass('is-invalid')
})

$('#senhaConfirmacao').keyup(function() {
  if ($('#senhaConfirmacao').val().length == $('#senhaCadastro').val().length &&
      $('#senhaConfirmacao').val() != $('#senhaCadastro').val()) {
    $($('#senhaConfirmacao')).addClass('is-invalid')
  }

  if ($('#senhaConfirmacao').val().length > $('#senhaCadastro').val().length)
    $($('#senhaConfirmacao')).addClass('is-invalid')

  if ($('#senhaConfirmacao').val() == $('#senhaCadastro').val())
    $(this).removeClass('is-invalid')
})
