$createDelegate = function(instance, method) {
    return function() { 
        return method.apply(instance, arguments);   
    };
};

// Para não deixar o corpo da página embaixo da barra fixa
$(window).ready(ajustaAltura());
$(window).resize(() => ajustaAltura());

function ajustaAltura() {
  let margem = $('nav').height();
  $('.corpo').css('margin-top', margem + 30);
}

// Selecionar os horários com o clique
$(".horario").click(function() {
  $(this).toggleClass('active');
});


