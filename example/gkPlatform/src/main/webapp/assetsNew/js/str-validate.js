/**
 * Created by LL on 2018/3/15.
 */
/*非空校验方法*/
function isEmpty(str) {
    var strNew = removeAllTrim(str);
    if (strNew == "" || strNew == undefined || strNew == null) {
        layer.msg("必填项不能为空");
        return false;
    } else {
        return true;
    }
}

//去掉了两头空格
function removeTwoHeadTrim(str) {
    var strNew = str.replace(/(^\s*)|(\s*$)/g, "");
    return strNew;
}

//去掉所有空格
function removeAllTrim(str) {
    var strNew = str.replace(/\s|\xA0/g, "");
    return strNew;
}


//去掉中间空格
function removeMiddleTrim(str, is_global) {
    var result;
    result = str.replace(/(^\s+)|(\s+$)/g, "");
    if (is_global.toLowerCase() == "g") {
        result = result.replace(/\s/g, "");
    }
    return result;
}

//整数校验
function isInteger(str) {
    var isNum = parseInt(removeAllTrim(str));
    if (typeof isNum === 'number' && isNum % 1 === 0) {
        return true;
    } else {
        layer.msg("请按要求填写整数");
        return false;
    }
}

//长度校验
function standardLength(str) {
    var _str = str.removeAllTrim(str);
    if (_str.length() > 50) {
        layer.msg("字数不符合要求");
        return false;
    } else {
        return true;
    }
}

//纯英文校验
function isEnglish(str) {
    var strNew = removeAllTrim(str);
    if (/[A-Za-z]+$/.test(strNew)) {
        return true;
    } else {
        layer.msg("格式不符合要求");
        return false;
    }
}


