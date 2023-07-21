function soloNumeros(e){
    
    if(e.ctrlKey)
        return true;
    var key = window.Event ? e.which : e.keyCode        
    return ((key >= 48 && key <= 57) || (key >= 95 && key < 106) || key==8 || key==46 || key==37 || key==39 || key==9 || key==16 || key==17 || key==116)
}

function validarSiNumero(numero){
    if(isNaN(numero.value))
    {
        numero.value="";
        return false;
    }
    numero.value = numero.value.split(" ").join("");
    return true;
}


function validarSiNumeroSinCero(numero){
    if(isNaN(numero.value))
    {
        numero.value="";
        return false;
    }
    if(numero.value ==="0"){
         numero.value="";
        return false;
    }
    numero.value = numero.value.split(" ").join("");
   
    return true;
}


function soloNumerosConDecimal(e){
    if(e.ctrlKey)
        return true;
    var key = window.Event ? e.which : e.keyCode    
   
    return ((key >= 48 && key <= 57) || (key >= 95 && key <= 106) || key==8 || key==46 || key==37 || key==39 || key==9 || key==16 || key==17 || key==110 || key==190 || key==116)
}

function soloNumerosDecimal(e){
    if(e.ctrlKey)
        return true;
    var key = window.Event ? e.which : e.keyCode    
//    alert(key);
//   if(key ==110 || key ==190){
//       e.keyCode=188 ;
//   }
//    alert(key);
    return ((key >= 48 && key <= 57) || (key >= 95 && key <= 106) || key==8 || key==46 || key==37 || key==39 || key==9 || key==16 || key==17 || key==188 || key==116)
}




function sinCaracteres(e){
    if(e.ctrlKey)
        return true;
    var key = window.Event ? e.which : e.charCode;
    var key1 = e.keyCode;
    if(key1==9 || key1==37 || key1==39 || key1==46)
    {
        return true;
    }
    //alert(key1);
    if((key>=48 && key<=57) || (key>=97 && key<=122) || (key>=65 && key<=90) || key==32 || key==8 || key==95 || key==45 || key==46 || key==209 || key==241)
    {
        return true;
    }
    return false;
}

function letrasNumeros(e){
    if(e.ctrlKey)
        return true;
    var key = window.Event ? e.which : e.charCode;
    var key1 = e.keyCode;
    if(key1==9 || key1==37 || key1==39 || key1==46)
    {
        return true;
    }
    //alert(key);
    if((key>=48 && key<=57) || (key>=97 && key<=122) || (key>=65 && key<=90) || key==32 || key==8 || key==95  || key==209 || key==241)
    {
        return true;
    }
    return false;
}

function soloIngresarLetras(e){
    if(e.ctrlKey)
        return true;
    var key = window.Event ? e.which : e.charCode;
    var key1 = e.keyCode;
    if(key1==9 || key1==37 || key1==39 || key1==46)
    {
        return true;
    }
    //alert(key);
    if((key>=97 && key<=122) || (key>=65 && key<=90) || key==32 || key==8 || key==95 || key==209 || key==241)
    {
        return true;
    }
    return false;
}