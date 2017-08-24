var T,
	baidu = T = baidu || {
		version : "1.3.5"
	};
baidu.guid = "$BAIDU$";
window[baidu.guid] = window[baidu.guid] || {};
baidu.browser = baidu.browser || {};
baidu.browser.isGecko = /gecko/i.test(navigator.userAgent) && !/like gecko/i.test(navigator.userAgent);
baidu.browser.isStrict = document.compatMode == "CSS1Compat";(function() {
	var a = navigator.userAgent;
	if (/(\d+\.\d)?(?:\.\d)?\s+safari\/?(\d+\.\d+)?/i.test(a) && !/chrome/i.test(a)) {
		baidu.browser.safari = +(RegExp["\x241"] || RegExp["\x242"])
	}
})();
if (/opera\/(\d+\.\d)/i.test(navigator.userAgent)) {
	baidu.browser.opera = +RegExp["\x241"]
}
if (/chrome\/(\d+\.\d)/i.test(navigator.userAgent)) {
	baidu.browser.chrome = +RegExp["\x241"]
}
if (/msie (\d+\.\d)/i.test(navigator.userAgent)) {
	baidu.browser.ie = baidu.ie = document.documentMode || +RegExp["\x241"]
}
try {
	if (/(\d+\.\d)/.test(external.max_version)) {
		baidu.browser.maxthon = +RegExp["\x241"]
	}
} catch (e) {}
baidu.browser.isWebkit = /webkit/i.test(navigator.userAgent);
if (/firefox\/(\d+\.\d)/i.test(navigator.userAgent)) {
	baidu.browser.firefox = +RegExp["\x241"]
}
baidu.number = baidu.number || {};
baidu.number.pad = function(d, c) {
	var f = "",
		b = (d < 0),
		a = String(Math.abs(d));
	if (a.length < c) {
		f = (new Array(c - a.length + 1)).join("0")
	}
	return (b ? "-" : "") + f + a
};
baidu.number.comma = function(b, a) {
	if (!a || a < 1) {
		a = 3
	}
	b = String(b).split(".");
	b[0] = b[0].replace(new RegExp("(\\d)(?=(\\d{" + a + "})+$)", "ig"), "$1,");return b.join(".")
};
baidu.url = baidu.url || {};
baidu.url.escapeSymbol = function(a) {
	return String(a).replace(/\%/g, "%25").replace(/&/g, "%26").replace(/\+/g, "%2B").replace(/\ /g, "%20").replace(/\//g, "%2F").replace(/\#/g, "%23").replace(/\=/g, "%3D")
};
baidu.string = baidu.string || {};
baidu.string.escapeReg = function(a) {
	return String(a).replace(new RegExp("([.*+?^=!:\x24{}()|[\\]/\\\\])", "g"), "\\\x241")
};
baidu.url.getQueryValue = function(b, c) {
	var d = new RegExp("(^|&|\\?|#)" + baidu.string.escapeReg(c) + "=([^&#]*)(&|\x24|#)", "");
	var a = b.match(d);
	if (a) {
		return a[2]
	}
	return null
};
baidu.object = baidu.object || {};
baidu.object.each = function(f, c) {
	var b,
		a,
		d;
	if ("function" == typeof c) {
		for (a in f) {
			if (f.hasOwnProperty(a)) {
				d = f[a];
				b = c.call(f, d, a);
				if (b === false) {
					break
				}
			}
		}
	}
	return f
};
baidu.lang = baidu.lang || {};
baidu.lang.isArray = function(a) {
	return "[object Array]" == Object.prototype.toString.call(a)
};
baidu.url.jsonToQuery = function(c, f) {
	var a = [],
		d,
		b = f || function(g) {
			return baidu.url.escapeSymbol(g)
		};
	baidu.object.each(c, function(h, g) {
		if (baidu.lang.isArray(h)) {
			d = h.length;
			while (d--) {
				a.push(g + "=" + b(h[d], g))
			}
		} else {
			a.push(g + "=" + b(h, g))
		}
	});return a.join("&")
};
baidu.url.queryToJson = function(a) {
	var g = a.substr(a.lastIndexOf("?") + 1),
		c = g.split("&"),
		f = c.length,
		l = {},
		d = 0,
		j,
		h,
		k,
		b;
	for (; d < f; d++) {
		b = c[d].split("=");
		j = b[0];
		h = b[1];
		k = l[j];
		if ("undefined" == typeof k) {
			l[j] = h
		} else {
			if (baidu.lang.isArray(k)) {
				k.push(h)
			} else {
				l[j] = [ k, h ]
			}
		}
	}
	return l
};
baidu.cookie = baidu.cookie || {};
baidu.cookie._isValidKey = function(a) {
	return (new RegExp('^[^\\x00-\\x20\\x7f\\(\\)<>@,;:\\\\\\"\\[\\]\\?=\\{\\}\\/\\u0080-\\uffff]+\x24')).test(a)
};
baidu.cookie.setRaw = function(c, d, b) {
	if (!baidu.cookie._isValidKey(c)) {
		return
	}
	b = b || {};
	var a = b.expires;
	if ("number" == typeof b.expires) {
		a = new Date();a.setTime(a.getTime() + b.expires)
	}
	document.cookie = c + "=" + d + (b.path ? "; path=" + b.path : "") + (a ? "; expires=" + a.toGMTString() : "") + (b.domain ? "; domain=" + b.domain : "") + (b.secure ? "; secure" : "")
};
baidu.cookie.getRaw = function(b) {
	if (baidu.cookie._isValidKey(b)) {
		var c = new RegExp("(^| )" + b + "=([^;]*)(;|\x24)"),
			a = c.exec(document.cookie);
		if (a) {
			return a[2] || null
		}
	}
	return null
};
baidu.cookie.get = function(a) {
	var b = baidu.cookie.getRaw(a);
	if ("string" == typeof b) {
		b = decodeURIComponent(b);return b
	}
	return null
};
baidu.cookie.set = function(b, c, a) {
	baidu.cookie.setRaw(b, encodeURIComponent(c), a)
};
baidu.cookie.remove = function(b, a) {
	a = a || {};
	a.expires = new Date(0);baidu.cookie.setRaw(b, "", a)
};
baidu.json = baidu.json || {};
baidu.json.parse = function(a) {
	return (new Function("return (" + a + ")"))()
};
baidu.json.stringify = (function() {
	var b = {
		"\b" : "\\b",
		"\t" : "\\t",
		"\n" : "\\n",
		"\f" : "\\f",
		"\r" : "\\r",
		'"' : '\\"',
		"\\" : "\\\\"
	};
	function a(g) {
		if (/["\\\x00-\x1f]/.test(g)) {
			g = g.replace(/["\\\x00-\x1f]/g, function(h) {
				var i = b[h];
				if (i) {
					return i
				}
				i = h.charCodeAt();return "\\u00" + Math.floor(i / 16).toString(16) + (i % 16).toString(16)
			})
		}
		return '"' + g + '"'
	}
	function d(n) {
		var h = [ "[" ],
			j = n.length,
			g,
			k,
			m;
		for (k = 0; k < j; k++) {
			m = n[k];switch (typeof m) {
			case "undefined":
			case "function":
			case "unknown":
				break;default:
				if (g) {
					h.push(",")
				}
				h.push(baidu.json.stringify(m));g = 1
			}
		}
		h.push("]");return h.join("")
	}
	function c(g) {
		return g < 10 ? "0" + g : g
	}
	function f(g) {
		return '"' + g.getFullYear() + "-" + c(g.getMonth() + 1) + "-" + c(g.getDate()) + "T" + c(g.getHours()) + ":" + c(g.getMinutes()) + ":" + c(g.getSeconds()) + '"'
	}
	return function(l) {
		switch (typeof l) {
		case "undefined":
			return "undefined";case "number":
			return isFinite(l) ? String(l) : "null";case "string":
			return a(l);case "boolean":
			return String(l);default:
			if (l === null) {
				return "null"
			} else {
				if (l instanceof Array) {
					return d(l)
				} else {
					if (l instanceof Date) {
						return f(l)
					} else {
						var h = [ "{" ],
							k = baidu.json.stringify,
							g,
							j;
						for (var i in l) {
							if (Object.prototype.hasOwnProperty.call(l, i)) {
								j = l[i];switch (typeof j) {
								case "undefined":
								case "unknown":
								case "function":
									break;default:
									if (g) {
										h.push(",")
									}
									g = 1;h.push(k(i) + ":" + k(j))
								}
							}
						}
						h.push("}");return h.join("")
					}
				}
			}
		}
	}
})();
baidu.json.encode = baidu.json.stringify;
baidu.json.decode = baidu.json.parse;
baidu.date = baidu.date || {};
baidu.date.format = function(a, g) {
	if ("string" != typeof g) {
		return a.toString()
	}
	function d(m, l) {
		g = g.replace(m, l)
	}
	var b = baidu.number.pad,
		h = a.getFullYear(),
		f = a.getMonth() + 1,
		k = a.getDate(),
		i = a.getHours(),
		c = a.getMinutes(),
		j = a.getSeconds();
	d(/yyyy/g, b(h, 4));d(/yy/g, b(h.toString().slice(2), 2));d(/MM/g, b(f, 2));d(/M/g, f);d(/dd/g, b(k, 2));d(/d/g, k);d(/HH/g, b(i, 2));d(/H/g, i);d(/hh/g, b(i % 12, 2));d(/h/g, i % 12);d(/mm/g, b(c, 2));d(/m/g, c);d(/ss/g, b(j, 2));d(/s/g, j);return g
};
baidu.date.parse = function(c) {
	var a = new RegExp("^\\d+(\\-|\\/)\\d+(\\-|\\/)\\d+\x24");
	if ("string" == typeof c) {
		if (a.test(c) || isNaN(Date.parse(c))) {
			var g = c.split(/ |T/),
				b = g.length > 1 ? g[1].split(/[^\d]/) : [ 0, 0, 0 ],
				f = g[0].split(/[^\d]/);
			return new Date(f[0] - 0, f[1] - 1, f[2] - 0, b[0] - 0, b[1] - 0, b[2] - 0)
		} else {
			return new Date(c)
		}
	}
	return new Date()
};
baidu.dom = baidu.dom || {};
baidu.dom._styleFilter = baidu.dom._styleFilter || [];
baidu.dom._styleFilter[baidu.dom._styleFilter.length] = {
	get : function(c, d) {
		if (/color/i.test(c) && d.indexOf("rgb(") != -1) {
			var f = d.split(",");
			d = "#";
			for (var b = 0, a; a = f[b]; b++) {
				a = parseInt(a.replace(/[^\d]/gi, ""), 10).toString(16);
				d += a.length == 1 ? "0" + a : a
			}
			d = d.toUpperCase()
		}
		return d
	}
};
baidu.dom._styleFilter.filter = function(b, f, g) {
	for (var a = 0, d = baidu.dom._styleFilter, c; c = d[a]; a++) {
		if (c = c[g]) {
			f = c(b, f)
		}
	}
	return f
};
baidu.dom._styleFilter[baidu.dom._styleFilter.length] = {
	set : function(a, b) {
		if (b.constructor == Number && !/zIndex|fontWeight|opacity|zoom|lineHeight/i.test(a)) {
			b = b + "px"
		}
		return b
	}
};
baidu.dom._styleFixer = baidu.dom._styleFixer || {};
baidu.dom._styleFixer.display = baidu.browser.ie && baidu.browser.ie < 8 ? {
	set : function(a, b) {
		a = a.style;
		if (b == "inline-block") {
			a.display = "inline";
			a.zoom = 1
		} else {
			a.display = b
		}
	}
} : baidu.browser.firefox && baidu.browser.firefox < 3 ? {
	set : function(a, b) {
		a.style.display = b == "inline-block" ? "-moz-inline-box" : b
	}
} : null;
baidu.dom._styleFixer["float"] = baidu.browser.ie ? "styleFloat" : "cssFloat";
baidu.dom._styleFixer.opacity = baidu.browser.ie ? {
	get : function(a) {
		var b = a.style.filter;
		return b && b.indexOf("opacity=") >= 0 ? (parseFloat(b.match(/opacity=([^)]*)/)[1]) / 100) + "" : "1"
	},
	set : function(a, c) {
		var b = a.style;
		b.filter = (b.filter || "").replace(/alpha\([^\)]*\)/gi, "") + (c == 1 ? "" : "alpha(opacity=" + c * 100 + ")");
		b.zoom = 1
	}
} : null;
baidu.dom.g = function(a) {
	if ("string" == typeof a || a instanceof String) {
		return document.getElementById(a)
	} else {
		if (a && a.nodeName && (a.nodeType == 1 || a.nodeType == 9)) {
			return a
		}
	}
	return null
};
baidu.g = baidu.G = baidu.dom.g;
baidu.lang.isString = function(a) {
	return "[object String]" == Object.prototype.toString.call(a)
};
baidu.isString = baidu.lang.isString;
baidu.dom._g = function(a) {
	if (baidu.lang.isString(a)) {
		return document.getElementById(a)
	}
	return a
};
baidu._g = baidu.dom._g;
baidu.dom.getDocument = function(a) {
	a = baidu.dom.g(a);return a.nodeType == 9 ? a : a.ownerDocument || a.document
};
baidu.dom.getComputedStyle = function(b, a) {
	b = baidu.dom._g(b);
	var d = baidu.dom.getDocument(b),
		c;
	if (d.defaultView && d.defaultView.getComputedStyle) {
		c = d.defaultView.getComputedStyle(b, null);
		if (c) {
			return c[a] || c.getPropertyValue(a)
		}
	}
	return ""
};
baidu.string.toCamelCase = function(a) {
	if (a.indexOf("-") < 0 && a.indexOf("_") < 0) {
		return a
	}
	return a.replace(/[-_][^-_]/g, function(b) {
		return b.charAt(1).toUpperCase()
	})
};
baidu.dom.getStyle = function(c, b) {
	var f = baidu.dom;
	c = f.g(c);
	b = baidu.string.toCamelCase(b);
	var d = c.style[b] || (c.currentStyle ? c.currentStyle[b] : "") || f.getComputedStyle(c, b);
	if (!d) {
		var a = f._styleFixer[b];
		d = a && a.get ? a.get(c) : baidu.dom.getStyle(c, a)
	}
	if (a = f._styleFilter) {
		d = a.filter(b, d, "get")
	}
	return d
};
baidu.getStyle = baidu.dom.getStyle;
baidu.dom._styleFixer.textOverflow = (function() {
	var b = {};
	function a(f) {
		var g = f.length;
		if (g > 0) {
			g = f[g - 1];f.length--
		} else {
			g = null
		}
		return g
	}
	function c(f, g) {
		f[baidu.browser.firefox ? "textContent" : "innerText"] = g
	}
	function d(n, j, t) {
		var l = baidu.browser.ie ? n.currentStyle || n.style : getComputedStyle(n, null),
			s = l.fontWeight,
			r = "font-family:" + l.fontFamily + ";font-size:" + l.fontSize + ";word-spacing:" + l.wordSpacing + ";font-weight:" + ((parseInt(s) || 0) == 401 ? 700 : s) + ";font-style:" + l.fontStyle + ";font-variant:" + l.fontVariant,
			f = b[r];
		if (!f) {
			l = n.appendChild(document.createElement("div"));
			l.style.cssText = "float:left;" + r;
			f = b[r] = [];
			for (var p = 0; p < 256; p++) {
				p == 32 ? (l.innerHTML = "&nbsp;") : c(l, String.fromCharCode(p));
				f[p] = l.offsetWidth
			}
			c(l, "\u4e00");
			f[256] = l.offsetWidth;c(l, "\u4e00\u4e00");
			f[257] = l.offsetWidth - f[256] * 2;
			f[258] = f[".".charCodeAt(0)] * 3 + f[257] * 3;n.removeChild(l)
		}
		for (var m = n.firstChild, q = f[256], h = f[257], g = f[258], v = [], t = t ? g : 0; m; m = m.nextSibling) {
			if (j < t) {
				n.removeChild(m)
			} else {
				if (m.nodeType == 3) {
					for (var p = 0, u = m.nodeValue, k = u.length; p < k; p++) {
						l = u.charCodeAt(p);
						v[v.length] = [ j, m, p ];
						j -= (p ? h : 0) + (l < 256 ? f[l] : q);
						if (j < t) {
							break
						}
					}
				} else {
					l = m.tagName;
					if (l == "IMG" || l == "TABLE") {
						l = m;
						m = m.previousSibling;n.removeChild(l)
					} else {
						v[v.length] = [ j, m ];
						j -= m.offsetWidth
					}
				}
			}
		}
		if (j < t) {
			while (l = a(v)) {
				j = l[0];
				m = l[1];
				l = l[2];
				if (m.nodeType == 3) {
					if (j >= g) {
						m.nodeValue = m.nodeValue.substring(0, l) + "...";return true
					} else {
						if (!l) {
							n.removeChild(m)
						}
					}
				} else {
					if (d(m, j, true)) {
						return true
					} else {
						n.removeChild(m)
					}
				}
			}
			n.innerHTML = ""
		}
	}
	return {
		get : function(h) {
			var g = baidu.browser,
				f = dom.getStyle;
			return (g.opera ? f("OTextOverflow") : g.firefox ? h._baiduOverflow : f("textOverflow")) || "clip"
		},
		set : function(g, i) {
			var f = baidu.browser;
			if (g.tagName == "TD" || g.tagName == "TH" || f.firefox) {
				g._baiduHTML && (g.innerHTML = g._baiduHTML);
				if (i == "ellipsis") {
					g._baiduHTML = g.innerHTML;
					var j = document.createElement("div"),
						h = g.appendChild(j).offsetWidth;
					g.removeChild(j);d(g, h)
				} else {
					g._baiduHTML = ""
				}
			}
			j = g.style;
			f.opera ? (j.OTextOverflow = i) : f.firefox ? (g._baiduOverflow = i) : (j.textOverflow = i)
		}
	}
})();
baidu.dom._NAME_ATTRS = (function() {
	var a = {
		cellpadding : "cellPadding",
		cellspacing : "cellSpacing",
		colspan : "colSpan",
		rowspan : "rowSpan",
		valign : "vAlign",
		usemap : "useMap",
		frameborder : "frameBorder"
	};
	if (baidu.browser.ie < 8) {
		a["for"] = "htmlFor";
		a["class"] = "className"
	} else {
		a.htmlFor = "for";
		a.className = "class"
	}
	return a
})();
baidu.dom.setAttr = function(b, a, c) {
	b = baidu.dom.g(b);
	if ("style" == a) {
		b.style.cssText = c
	} else {
		a = baidu.dom._NAME_ATTRS[a] || a;b.setAttribute(a, c)
	}
	return b
};
baidu.setAttr = baidu.dom.setAttr;
baidu.dom.setAttrs = function(c, a) {
	c = baidu.dom.g(c);
	for (var b in a) {
		baidu.dom.setAttr(c, b, a[b])
	}
	return c
};
baidu.setAttrs = baidu.dom.setAttrs;
baidu.dom.getAttr = function(b, a) {
	b = baidu.dom.g(b);
	if ("style" == a) {
		return b.style.cssText
	}
	a = baidu.dom._NAME_ATTRS[a] || a;return b.getAttribute(a)
};
baidu.getAttr = baidu.dom.getAttr;
baidu.dom._matchNode = function(a, c, d) {
	a = baidu.dom.g(a);
	for (var b = a[d]; b; b = b[c]) {
		if (b.nodeType == 1) {
			return b
		}
	}
	return null
};
baidu.dom.prev = function(a) {
	return baidu.dom._matchNode(a, "previousSibling", "previousSibling")
};(function() {
	var a = new RegExp("(^[\\s\\t\\xa0\\u3000]+)|([\\u3000\\xa0\\s\\t]+\x24)", "g");
	baidu.string.trim = function(b) {
		return String(b).replace(a, "")
	}
})();
baidu.trim = baidu.string.trim;
baidu.dom.addClass = function(g, h) {
	g = baidu.dom.g(g);
	var b = h.split(/\s+/),
		a = g.className,
		f = " " + a + " ",
		d = 0,
		c = b.length;
	for (; d < c; d++) {
		if (f.indexOf(" " + b[d] + " ") < 0) {
			a += (a ? " " : "") + b[d]
		}
	}
	g.className = a;return g
};
baidu.addClass = baidu.dom.addClass;
baidu.dom.hasClass = function(c, d) {
	c = baidu.dom.g(c);
	var b = baidu.string.trim(d).split(/\s+/),
		a = b.length;
	d = c.className.split(/\s+/).join(" ");
	while (a--) {
		if (!(new RegExp("(^| )" + b[a] + "( |\x24)")).test(d)) {
			return false
		}
	}
	return true
};
baidu.dom.contains = function(a, b) {
	var c = baidu.dom._g;
	a = c(a);
	b = c(b);return a.contains ? a != b && a.contains(b) : !!(a.compareDocumentPosition(b) & 16)
};
baidu.dom.removeClass = function(g, h) {
	g = baidu.dom.g(g);
	var d = g.className.split(/\s+/),
		k = h.split(/\s+/),
		b,
		a = k.length,
		c,
		f = 0;
	for (; f < a; ++f) {
		for (c = 0, b = d.length; c < b; ++c) {
			if (d[c] == k[f]) {
				d.splice(c, 1);break
			}
		}
	}
	g.className = d.join(" ");return g
};
baidu.removeClass = baidu.dom.removeClass;
baidu.dom.children = function(b) {
	b = baidu.dom.g(b);
	for (var a = [], c = b.firstChild; c; c = c.nextSibling) {
		if (c.nodeType == 1) {
			a.push(c)
		}
	}
	return a
};
baidu.dom.setStyle = function(c, b, d) {
	var f = baidu.dom,
		a;
	c = f.g(c);
	b = baidu.string.toCamelCase(b);
	if (a = f._styleFilter) {
		d = a.filter(b, d, "set")
	}
	a = f._styleFixer[b];
	(a && a.set) ? a.set(c, d) : (c.style[a || b] = d);return c
};
baidu.setStyle = baidu.dom.setStyle;
baidu.dom.setStyles = function(b, c) {
	b = baidu.dom.g(b);
	for (var a in c) {
		baidu.dom.setStyle(b, a, c[a])
	}
	return b
};
baidu.setStyles = baidu.dom.setStyles;
baidu.dom.q = function(j, f, b) {
	var k = [],
		d = baidu.string.trim,
		h,
		g,
		a,
		c;
	if (!(j = d(j))) {
		return k
	}
	if ("undefined" == typeof f) {
		f = document
	} else {
		f = baidu.dom.g(f);
		if (!f) {
			return k
		}
	}
	b && (b = d(b).toUpperCase());
	if (f.getElementsByClassName) {
		a = f.getElementsByClassName(j);
		h = a.length;
		for (g = 0; g < h; g++) {
			c = a[g];
			if (b && c.tagName != b) {
				continue
			}
			k[k.length] = c
		}
	} else {
		j = new RegExp("(^|\\s)" + baidu.string.escapeReg(j) + "(\\s|\x24)");
		a = b ? f.getElementsByTagName(b) : (f.all || f.getElementsByTagName("*"));
		h = a.length;
		for (g = 0; g < h; g++) {
			c = a[g];j.test(c.className) && (k[k.length] = c)
		}
	}
	return k
};
baidu.q = baidu.Q = baidu.dom.q;
baidu.dom.getPosition = function(a) {
	a = baidu.dom.g(a);
	var k = baidu.dom.getDocument(a),
		d = baidu.browser,
		h = baidu.dom.getStyle,
		c = d.isGecko > 0 && k.getBoxObjectFor && h(a, "position") == "absolute" && (a.style.top === "" || a.style.left === ""),
		i = {
			left : 0,
			top : 0
		},
		g = (d.ie && !d.isStrict) ? k.body : k.documentElement,
		l,
		b;
	if (a == g) {
		return i
	}
	if (a.getBoundingClientRect) {
		b = a.getBoundingClientRect();
		i.left = Math.floor(b.left) + Math.max(k.documentElement.scrollLeft, k.body.scrollLeft);
		i.top = Math.floor(b.top) + Math.max(k.documentElement.scrollTop, k.body.scrollTop);
		i.left -= k.documentElement.clientLeft;
		i.top -= k.documentElement.clientTop;
		var j = k.body,
			m = parseInt(h(j, "borderLeftWidth")),
			f = parseInt(h(j, "borderTopWidth"));
		if (d.ie && !d.isStrict) {
			i.left -= isNaN(m) ? 2 : m;
			i.top -= isNaN(f) ? 2 : f
		}
	} else {
		l = a;
		do {
			i.left += l.offsetLeft;
			i.top += l.offsetTop;
			if (d.isWebkit > 0 && h(l, "position") == "fixed") {
				i.left += k.body.scrollLeft;
				i.top += k.body.scrollTop;break
			}
			l = l.offsetParent
		} while (l && l != a);
		if (d.opera > 0 || (d.isWebkit > 0 && h(a, "position") == "absolute")) {
			i.top -= k.body.offsetTop
		}
		l = a.offsetParent;
		while (l && l != k.body) {
			i.left -= l.scrollLeft;
			if (!d.opera || l.tagName != "TR") {
				i.top -= l.scrollTop
			}
			l = l.offsetParent
		}
	}
	return i
};
baidu.dom.intersect = function(j, i) {
	var h = baidu.dom.g,
		f = baidu.dom.getPosition,
		a = Math.max,
		c = Math.min;
	j = h(j);
	i = h(i);
	var d = f(j),
		b = f(i);
	return a(d.left, b.left) <= c(d.left + j.offsetWidth, b.left + i.offsetWidth) && a(d.top, b.top) <= c(d.top + j.offsetHeight, b.top + i.offsetHeight)
};
baidu.dom.last = function(a) {
	return baidu.dom._matchNode(a, "previousSibling", "lastChild")
};(function() {
	var a = baidu.dom.ready = function() {
		var f = false,
			d = [];
		function b() {
			if (!b.isReady) {
				b.isReady = true;
				for (var h = 0, g = d.length; h < g; h++) {
					d[h]()
				}
			}
		}
		function c() {
			if (f) {
				return
			}
			f = true;var j = document,
				h = window,
				g = baidu.browser.opera;
			if (j.addEventListener) {
				j.addEventListener("DOMContentLoaded", g ? function() {
					if (b.isReady) {
						return
					}
					for (var k = 0; k < j.styleSheets.length; k++) {
						if (j.styleSheets[k].disabled) {
							setTimeout(arguments.callee, 0);return
						}
					}
					b()
				} : b, false)
			} else {
				if (baidu.browser.ie && h == top) {
					(function() {
						if (b.isReady) {
							return
						}
						try {
							j.documentElement.doScroll("left")
						} catch (k) {
							setTimeout(arguments.callee, 0);return
						} b()
					})()
				} else {
					if (baidu.browser.safari) {
						var i;
						(function() {
							if (b.isReady) {
								return
							}
							if (j.readyState != "loaded" && j.readyState != "complete") {
								setTimeout(arguments.callee, 0);return
							}
							if (i === undefined) {
								i = 0;
								var n = j.getElementsByTagName("style"),
									l = j.getElementsByTagName("link");
								if (n) {
									i += n.length
								}
								if (l) {
									for (var m = 0, k = l.length; m < k; m++) {
										if (l[m].getAttribute("rel") == "stylesheet") {
											i++
										}
									}
								}
							}
							if (j.styleSheets.length != i) {
								setTimeout(arguments.callee, 0);return
							}
							b()
						})()
					}
				}
			}
			h.attachEvent ? h.attachEvent("onload", b) : h.addEventListener("load", b, false)
		}
		c();return function(g) {
			b.isReady ? g() : (d[d.length] = g)
		}
	}();
	a.isReady = false
})();
baidu.dom.getAncestorByTag = function(b, a) {
	b = baidu.dom.g(b);
	a = a.toUpperCase();
	while ((b = b.parentNode) && b.nodeType == 1) {
		if (b.tagName == a) {
			return b
		}
	}
	return null
};
baidu.dom.getWindow = function(a) {
	a = baidu.dom.g(a);
	var b = baidu.dom.getDocument(a);
	return b.parentWindow || b.defaultView || null
};
baidu.dom.getAncestorBy = function(a, b) {
	a = baidu.dom.g(a);
	while ((a = a.parentNode) && a.nodeType == 1) {
		if (b(a)) {
			return a
		}
	}
	return null
};
baidu.dom.hide = function(a) {
	a = baidu.dom.g(a);
	a.style.display = "none";return a
};
baidu.hide = baidu.dom.hide;
baidu.dom.next = function(a) {
	return baidu.dom._matchNode(a, "nextSibling", "nextSibling")
};
baidu.dom.show = function(a) {
	a = baidu.dom.g(a);
	a.style.display = "";return a
};
baidu.show = baidu.dom.show;
baidu.dom.toggle = function(a) {
	a = baidu.dom.g(a);
	a.style.display = a.style.display == "none" ? "" : "none";return a
};
baidu.dom.insertAfter = function(d, c) {
	var b,
		a;
	b = baidu.dom._g;
	d = b(d);
	c = b(c);
	a = c.parentNode;
	if (a) {
		a.insertBefore(d, c.nextSibling)
	}
	return d
};
baidu.dom.first = function(a) {
	return baidu.dom._matchNode(a, "nextSibling", "firstChild")
};
baidu.dom.insertBefore = function(d, c) {
	var b,
		a;
	b = baidu.dom._g;
	d = b(d);
	c = b(c);
	a = c.parentNode;
	if (a) {
		a.insertBefore(d, c)
	}
	return d
};
baidu.dom.insertHTML = function(d, a, c) {
	d = baidu.dom.g(d);
	var b,
		f;
	if (d.insertAdjacentHTML) {
		d.insertAdjacentHTML(a, c)
	} else {
		b = d.ownerDocument.createRange();
		a = a.toUpperCase();
		if (a == "AFTERBEGIN" || a == "BEFOREEND") {
			b.selectNodeContents(d);b.collapse(a == "AFTERBEGIN")
		} else {
			f = a == "BEFOREBEGIN";b[f ? "setStartBefore" : "setEndAfter"](d);b.collapse(f)
		}
		b.insertNode(b.createContextualFragment(c))
	}
	return d
};
baidu.insertHTML = baidu.dom.insertHTML;
baidu.dom.remove = function(a) {
	a = baidu.dom._g(a);
	var b = a.parentNode;
	b && b.removeChild(a)
};
baidu.dom.getAncestorByClass = function(a, b) {
	a = baidu.dom.g(a);
	b = new RegExp("(^|\\s)" + baidu.string.trim(b) + "(\\s|\x24)");
	while ((a = a.parentNode) && a.nodeType == 1) {
		if (b.test(a.className)) {
			return a
		}
	}
	return null
};
window[baidu.guid]._instances = window[baidu.guid]._instances || {};
baidu.lang.instance = function(a) {
	return window[baidu.guid]._instances[a] || null
};
baidu.lang.isNumber = function(a) {
	return "[object Number]" == Object.prototype.toString.call(a) && isFinite(a)
};(function() {
	var a = window[baidu.guid];
	baidu.lang.guid = function() {
		return "TANGRAM__" + (a._counter++).toString(36)
	};
	a._counter = a._counter || 1
})();
baidu.lang.isFunction = function(a) {
	return "[object Function]" == Object.prototype.toString.call(a)
};
baidu.lang.Class = function(a) {
	this.guid = a || baidu.lang.guid();
	window[baidu.guid]._instances[this.guid] = this
};
window[baidu.guid]._instances = window[baidu.guid]._instances || {};
baidu.lang.Class.prototype.dispose = function() {
	delete window[baidu.guid]._instances[this.guid];
	for (var a in this) {
		if (!baidu.lang.isFunction(this[a])) {
			delete this[a]
		}
	}
	this.disposed = true
};
baidu.lang.Class.prototype.toString = function() {
	return "[object " + (this._className || "Object") + "]"
};
baidu.lang.inherits = function(h, f, d) {
	var c,
		g,
		a = h.prototype,
		b = new Function();
	b.prototype = f.prototype;
	g = h.prototype = new b();
	for (c in a) {
		g[c] = a[c]
	}
	h.prototype.constructor = h;
	h.superClass = f.prototype;
	if ("string" == typeof d) {
		g._className = d
	}
};
baidu.inherits = baidu.lang.inherits;
baidu.lang.isElement = function(a) {
	return !!(a && a.nodeName && a.nodeType == 1)
};
baidu.lang.module = function(name, module, owner) {
	var packages = name.split("."),
		len = packages.length - 1,
		packageName,
		i = 0;
	if (!owner) {
		try {
			if (!(new RegExp("^[a-zA-Z_\x24][a-zA-Z0-9_\x24]*\x24")).test(packages[0])) {
				throw ""
			}
			owner = eval(packages[0]);
			i = 1
		} catch (e) {
			owner = window
		}
	}
	for (; i < len; i++) {
		packageName = packages[i];
		if (!owner[packageName]) {
			owner[packageName] = {}
		}
		owner = owner[packageName]
	}
	if (!owner[packages[len]]) {
		owner[packages[len]] = module
	}
};
baidu.lang.decontrol = function(b) {
	var a = window[baidu.guid];
	a._instances && (
	delete a._instances[b]
	)
};
baidu.lang.Event = function(a, b) {
	this.type = a;
	this.returnValue = true;
	this.target = b || null;
	this.currentTarget = null
};
baidu.lang.Class.prototype.addEventListener = function(d, c, b) {
	if (!baidu.lang.isFunction(c)) {
		return
	}
	!this.__listeners && (this.__listeners = {});
	var a = this.__listeners,
		f;
	if (typeof b == "string" && b) {
		if (/[^\w\-]/.test(b)) {
			throw ("nonstandard key:" + b)
		} else {
			c.hashCode = b;
			f = b
		}
	}
	d.indexOf("on") != 0 && (d = "on" + d);typeof a[d] != "object" && (a[d] = {});
	f = f || baidu.lang.guid();
	c.hashCode = f;
	a[d][f] = c
};
baidu.lang.Class.prototype.removeEventListener = function(d, c) {
	if (typeof c != "undefined") {
		if (baidu.lang.isFunction(c)) {
			c = c.hashCode
		} else {
			if (!baidu.lang.isString(c)) {
				return
			}
		}
	}
	!this.__listeners && (this.__listeners = {});d.indexOf("on") != 0 && (d = "on" + d);
	var b = this.__listeners;
	if (!b[d]) {
		return
	}
	if (typeof c != "undefined") {
		b[d][c] &&
		delete b[d][c]
	} else {
		for (var a in b[d]) {
			delete b[d][a]
		}
	}
};
baidu.lang.Class.prototype.dispatchEvent = function(d, a) {
	if (baidu.lang.isString(d)) {
		d = new baidu.lang.Event(d)
	}
	!this.__listeners && (this.__listeners = {});
	a = a || {};
	for (var c in a) {
		d[c] = a[c]
	}
	var c,
		b = this.__listeners,
		f = d.type;
	d.target = d.target || this;
	d.currentTarget = this;f.indexOf("on") != 0 && (f = "on" + f);baidu.lang.isFunction(this[f]) && this[f].apply(this, arguments);
	if (typeof b[f] == "object") {
		for (c in b[f]) {
			b[f][c].apply(this, arguments)
		}
	}
	return d.returnValue
};
baidu.lang.isObject = function(a) {
	return "function" == typeof a || !!(a && "object" == typeof a)
};
baidu.isObject = baidu.lang.isObject;
baidu.event = baidu.event || {};
baidu.event.getPageX = function(b) {
	var a = b.pageX,
		c = document;
	if (!a && a !== 0) {
		a = (b.clientX || 0) + (c.documentElement.scrollLeft || c.body.scrollLeft)
	}
	return a
};
baidu.event.getPageY = function(b) {
	var a = b.pageY,
		c = document;
	if (!a && a !== 0) {
		a = (b.clientY || 0) + (c.documentElement.scrollTop || c.body.scrollTop)
	}
	return a
};
baidu.event.stopPropagation = function(a) {
	if (a.stopPropagation) {
		a.stopPropagation()
	} else {
		a.cancelBubble = true
	}
};
baidu.event.preventDefault = function(a) {
	if (a.preventDefault) {
		a.preventDefault()
	} else {
		a.returnValue = false
	}
};
baidu.event.stop = function(a) {
	var b = baidu.event;
	b.stopPropagation(a);b.preventDefault(a)
};
baidu.event.getTarget = function(a) {
	return a.target || a.srcElement
};
baidu.event.EventArg = function(c, f) {
	f = f || window;
	c = c || f.event;
	var d = f.document;
	this.target = (c.target) || c.srcElement;
	this.keyCode = c.which || c.keyCode;
	for (var a in c) {
		var b = c[a];
		if ("function" != typeof b) {
			this[a] = b
		}
	}
	if (!this.pageX && this.pageX !== 0) {
		this.pageX = (c.clientX || 0) + (d.documentElement.scrollLeft || d.body.scrollLeft);
		this.pageY = (c.clientY || 0) + (d.documentElement.scrollTop || d.body.scrollTop)
	}
	this._event = c
};
baidu.event.EventArg.prototype.preventDefault = function() {
	if (this._event.preventDefault) {
		this._event.preventDefault()
	} else {
		this._event.returnValue = false
	}
	return this
};
baidu.event.EventArg.prototype.stopPropagation = function() {
	if (this._event.stopPropagation) {
		this._event.stopPropagation()
	} else {
		this._event.cancelBubble = true
	}
	return this
};
baidu.event.EventArg.prototype.stop = function() {
	return this.stopPropagation().preventDefault()
};
baidu.event._listeners = baidu.event._listeners || [];
baidu.event.on = function(b, f, h) {
	f = f.replace(/^on/i, "");
	b = baidu.dom._g(b);
	var g = function(j) {
			h.call(b, j)
		},
		a = baidu.event._listeners,
		d = baidu.event._eventFilter,
		i,
		c = f;
	f = f.toLowerCase();
	if (d && d[f]) {
		i = d[f](b, f, g);
		c = i.type;
		g = i.listener
	}
	if (b.addEventListener) {
		b.addEventListener(c, g, false)
	} else {
		if (b.attachEvent) {
			b.attachEvent("on" + c, g)
		}
	}
	a[a.length] = [ b, f, h, g, c ];return b
};
baidu.on = baidu.event.on;
baidu.event.get = function(a, b) {
	return new baidu.event.EventArg(a, b)
};
baidu.event.un = function(c, g, b) {
	c = baidu.dom._g(c);
	g = g.replace(/^on/i, "").toLowerCase();
	var j = baidu.event._listeners,
		d = j.length,
		f = !b,
		i,
		h,
		a;
	while (d--) {
		i = j[d];
		if (i[1] === g && i[0] === c && (f || i[2] === b)) {
			h = i[4];
			a = i[3];
			if (c.removeEventListener) {
				c.removeEventListener(h, a, false)
			} else {
				if (c.detachEvent) {
					c.detachEvent("on" + h, a)
				}
			}
			j.splice(d, 1)
		}
	}
	return c
};
baidu.un = baidu.event.un;
baidu.event.getKeyCode = function(a) {
	return a.which || a.keyCode
};
baidu.ajax = baidu.ajax || {};
baidu.fn = baidu.fn || {};
baidu.fn.blank = function() {};
baidu.ajax.request = function(d, p) {
	p = p || {};
	var j = p.data || "",
		h = !(p.async === false),
		i = p.username || "",
		n = p.password || "",
		a = (p.method || "GET").toUpperCase(),
		g = p.headers || {},
		c = {},
		m,
		o;
	function k() {
		if (o.readyState == 4) {
			try {
				var r = o.status
			} catch (q) {
				f("failure");return
			} f(r);
			if ((r >= 200 && r < 300) || r == 304 || r == 1223) {
				f("success")
			} else {
				f("failure")
			}
			window.setTimeout(function() {
				o.onreadystatechange = baidu.fn.blank;
				if (h) {
					o = null
				}
			}, 0)
		}
	}
	function b() {
		if (window.ActiveXObject) {
			try {
				return new ActiveXObject("Msxml2.XMLHTTP")
			} catch (q) {
				try {
					return new ActiveXObject("Microsoft.XMLHTTP")
				} catch (q) {}
			}
		}
		if (window.XMLHttpRequest) {
			return new XMLHttpRequest()
		}
	}
	function f(s) {
		s = "on" + s;var r = c[s],
			t = baidu.ajax[s];
		if (r) {
			if (s != "onsuccess") {
				r(o)
			} else {
				try {
					o.responseText
				} catch (q) {
					return r(o)
				} r(o, o.responseText)
			}
		} else {
			if (t) {
				if (s == "onsuccess") {
					return
				}
				t(o)
			}
		}
	}
	for (m in p) {
		c[m] = p[m]
	}
	g["X-Requested-With"] = "XMLHttpRequest";try {
		o = b();
		if (a == "GET") {
			if (j) {
				d += (d.indexOf("?") >= 0 ? "&" : "?") + j;
				j = null
			}
			if (p.noCache) {
				d += (d.indexOf("?") >= 0 ? "&" : "?") + "b" + (+new Date) + "=1"
			}
		}
		if (i) {
			o.open(a, d, h, i, n)
		} else {
			o.open(a, d, h)
		}
		if (h) {
			o.onreadystatechange = k
		}
		if (a == "POST") {
			o.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
		}
		for (m in g) {
			if (g.hasOwnProperty(m)) {
				o.setRequestHeader(m, g[m])
			}
		}
		f("beforerequest");o.send(j);
		if (!h) {
			k()
		}
	} catch (l) {
		f("failure")
	} return o
};
baidu.ajax.post = function(b, c, a) {
	return baidu.ajax.request(b, {
		onsuccess : a,
		method : "POST",
		data : c
	})
};
baidu.ajax.get = function(b, a) {
	return baidu.ajax.request(b, {
		onsuccess : a
	})
};
baidu.ajax.form = function(a, c) {
	c = c || {};
	var g = a.elements,
		o = g.length,
		b = a.getAttribute("method"),
		f = a.getAttribute("action"),
		u = c.replacer || function(v, i) {
			return v
		},
		r = {},
		t = [],
		m,
		q,
		s,
		n,
		d,
		h,
		j,
		l,
		k;
	function p(i, v) {
		t.push(i + "=" + v)
	}
	for (m in c) {
		if (c.hasOwnProperty(m)) {
			r[m] = c[m]
		}
	}
	for (m = 0; m < o; m++) {
		q = g[m];
		n = q.name;
		if (!q.disabled && n) {
			s = q.type;
			d = q.value;switch (s) {
			case "radio":
			case "checkbox":
				if (!q.checked) {
					break
				}
			case "textarea":
			case "text":
			case "password":
			case "hidden":
			case "select-one":
				p(n, u(d, n));
				break;case "select-multiple":
				h = q.options;l = h.length;
				for (j = 0; j < l; j++) {
					k = h[j];
					if (k.selected) {
						p(n, u(k.value, n))
					}
				}
				break
			}
		}
	}
	r.data = t.join("&");
	r.method = a.getAttribute("method") || "POST";return baidu.ajax.request(f, r)
};
baidu.sio = baidu.sio || {};
baidu.sio._createScriptTag = function(b, a, c) {
	b.setAttribute("type", "text/javascript");c && b.setAttribute("charset", c);b.setAttribute("src", a);document.getElementsByTagName("head")[0].appendChild(b)
};
baidu.sio._removeScriptTag = function(b) {
	if (b.clearAttributes) {
		b.clearAttributes()
	} else {
		for (var a in b) {
			if (b.hasOwnProperty(a)) {
				delete b[a]
			}
		}
	}
	if (b && b.parentNode) {
		b.parentNode.removeChild(b)
	}
	b = null
};
baidu.sio.callByBrowser = function(a, h, j) {
	var d = document.createElement("SCRIPT"),
		f = 0,
		k = j || {},
		c = k.charset,
		i = h || function() {},
		g = k.timeOut || 0,
		b;
	d.onload = d.onreadystatechange = function() {
		if (f) {
			return
		}
		var l = d.readyState;
		if ("undefined" == typeof l || l == "loaded" || l == "complete") {
			f = 1;try {
				i();clearTimeout(b)
			} finally {
				d.onload = d.onreadystatechange = null;baidu.sio._removeScriptTag(d)
			}
		}
	};
	if (g) {
		b = setTimeout(function() {
			d.onload = d.onreadystatechange = null;baidu.sio._removeScriptTag(d);k.onfailure && k.onfailure()
		}, g)
	}
	baidu.sio._createScriptTag(d, a, c)
};
baidu.sio.callByServer = function(a, l, m) {
	var h = document.createElement("SCRIPT"),
		g = "bd__cbs__",
		j,
		d,
		n = m || {},
		c = n.charset,
		f = n.queryField || "callback",
		k = n.timeOut || 0,
		b;
	if (baidu.lang.isFunction(l)) {
		j = g + Math.floor(Math.random() * 2147483648).toString(36);
		window[j] = i(0)
	} else {
		j = l
	}
	if (k) {
		b = setTimeout(i(1), k)
	}
	function i(o) {
		return function() {
			try {
				if (o) {
					n.onfailure && n.onfailure()
				} else {
					l.apply(window, arguments);clearTimeout(b)
				}
				window[j] = null;
				delete window[j]
			} catch (p) {} finally {
				baidu.sio._removeScriptTag(h)
			}
		}
	}
	a = a.replace((new RegExp("(\\?|&)callback=[^&]*")), "\x241" + f + "=" + j);
	if (a.search(new RegExp("(\\?|&)" + f + "=/")) < 0) {
		a += (a.indexOf("?") < 0 ? "?" : "&") + f + "=" + j
	}
	baidu.sio._createScriptTag(h, a, c)
};
baidu.swf = baidu.swf || {};
baidu.swf.version = (function() {
	var h = navigator;
	if (h.plugins && h.mimeTypes.length) {
		var d = h.plugins["Shockwave Flash"];
		if (d && d.description) {
			return d.description.replace(/([a-zA-Z]|\s)+/, "").replace(/(\s)+r/, ".") + ".0"
		}
	} else {
		if (window.ActiveXObject && !window.opera) {
			for (var b = 10; b >= 2; b--) {
				try {
					var g = new ActiveXObject("ShockwaveFlash.ShockwaveFlash." + b);
					if (g) {
						var a = g.GetVariable("$version");
						return a.replace(/WIN/g, "").replace(/,/g, ".")
					}
				} catch (f) {}
			}
		}
	}
})();
baidu.string.encodeHTML = function(a) {
	return String(a).replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;").replace(/"/g, "&quot;").replace(/'/g, "&#39;")
};
baidu.encodeHTML = baidu.string.encodeHTML;
baidu.swf.createHTML = function(t) {
	t = t || {};
	var l = baidu.swf.version,
		h = t.ver || "6.0.0",
		g,
		d,
		f,
		c,
		j,
		s,
		a = {},
		p = baidu.string.encodeHTML;
	for (c in t) {
		a[c] = t[c]
	}
	t = a;
	if (l) {
		l = l.split(".");
		h = h.split(".");
		for (f = 0; f < 3; f++) {
			g = parseInt(l[f], 10);
			d = parseInt(h[f], 10);
			if (d < g) {
				break
			} else {
				if (d > g) {
					return ""
				}
			}
		}
	} else {
		return ""
	}
	var n = t.vars,
		m = [ "classid", "codebase", "id", "width", "height", "align" ];
	t.align = t.align || "middle";
	t.classid = "clsid:d27cdb6e-ae6d-11cf-96b8-444553540000";
	t.codebase = "http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0";
	t.movie = t.url || "";
	delete t.vars;
	delete t.url;
	if ("string" == typeof n) {
		t.flashvars = n
	} else {
		var q = [];
		for (c in n) {
			s = n[c];
			if (s) {
				q.push(c + "=" + encodeURIComponent(s))
			}
		}
		t.flashvars = q.join("&")
	}
	var o = [ "<object " ];
	for (f = 0, j = m.length; f < j; f++) {
		s = m[f];o.push(" ", s, '="', p(t[s]), '"')
	}
	o.push(">");
	var b = {
		wmode : 1,
		scale : 1,
		quality : 1,
		play : 1,
		loop : 1,
		menu : 1,
		salign : 1,
		bgcolor : 1,
		base : 1,
		allowscriptaccess : 1,
		allownetworking : 1,
		allowfullscreen : 1,
		seamlesstabbing : 1,
		devicefont : 1,
		swliveconnect : 1,
		flashvars : 1,
		movie : 1
	};
	for (c in t) {
		s = t[c];
		c = c.toLowerCase();
		if (b[c] && s) {
			o.push('<param name="' + c + '" value="' + p(s) + '" />')
		}
	}
	t.src = t.movie;
	t.name = t.id;
	delete t.id;
	delete t.movie;
	delete t.classid;
	delete t.codebase;
	t.type = "application/x-shockwave-flash";
	t.pluginspage = "http://www.macromedia.com/go/getflashplayer";o.push("<embed");
	var r;
	for (c in t) {
		s = t[c];
		if (s) {
			if ((new RegExp("^salign\x24", "i")).test(c)) {
				r = s;continue
			}
			o.push(" ", c, '="', p(s), '"')
		}
	}
	if (r) {
		o.push(' salign="', p(r), '"')
	}
	o.push("></embed></object>");return o.join("")
};
baidu.array = baidu.array || {};
baidu.array.remove = function(c, b) {
	var a = c.length;
	while (a--) {
		if (a in c && c[a] === b) {
			c.splice(a, 1)
		}
	}
	return c
};
baidu.lang.toArray = function(b) {
	if (b === null || b === undefined) {
		return []
	}
	if (baidu.lang.isArray(b)) {
		return b
	}
	if (typeof b.length !== "number" || typeof b === "string" || baidu.lang.isFunction(b)) {
		return [ b ]
	}
	if (b.item) {
		var a = b.length,
			c = new Array(a);
		while (a--) {
			c[a] = b[a]
		}
		return c
	}
	return [].slice.call(b)
};
baidu.swf.getMovie = function(c) {
	var a = document[c],
		b;
	return baidu.browser.ie == 9 ? a && a.length ? (b = baidu.array.remove(baidu.lang.toArray(a), function(d) {
		return d.tagName.toLowerCase() != "embed"
	})).length == 1 ? b[0] : b : a : a || window[c]
};
baidu.swf.create = function(a, c) {
	a = a || {};
	var b = baidu.swf.createHTML(a) || a.errorMessage || "";
	if (c && "string" == typeof c) {
		c = document.getElementById(c)
	}
	if (c) {
		c.innerHTML = b
	} else {
		document.write(b)
	}
};
baidu.extend = baidu.object.extend = function(c, a) {
	for (var b in a) {
		if (a.hasOwnProperty(b)) {
			c[b] = a[b]
		}
	}
	return c
};
baidu.object.keys = function(d) {
	var a = [],
		c = 0,
		b;
	for (b in d) {
		if (d.hasOwnProperty(b)) {
			a[c++] = b
		}
	}
	return a
};
baidu.object.values = function(d) {
	var a = [],
		c = 0,
		b;
	for (b in d) {
		if (d.hasOwnProperty(b)) {
			a[c++] = d[b]
		}
	}
	return a
};
baidu.object.isPlain = function(c) {
	var b = Object.prototype.hasOwnProperty,
		a;
	if (!c || Object.prototype.toString.call(c) !== "[object Object]" || !("isPrototypeOf" in c)) {
		return false
	}
	if (c.constructor && !b.call(c, "constructor") && !b.call(c.constructor.prototype, "isPrototypeOf")) {
		return false
	}
	for (a in c) {} return a === undefined || b.call(c, a)
};
baidu.object.clone = function(f) {
	var b = f,
		c,
		a;
	if (!f || f instanceof Number || f instanceof String || f instanceof Boolean) {
		return b
	} else {
		if (baidu.lang.isArray(f)) {
			b = [];
			var d = 0;
			for (c = 0, a = f.length; c < a; c++) {
				b[d++] = baidu.object.clone(f[c])
			}
		} else {
			if (baidu.object.isPlain(f)) {
				b = {};
				for (c in f) {
					if (f.hasOwnProperty(c)) {
						b[c] = baidu.object.clone(f[c])
					}
				}
			}
		}
	}
	return b
};
baidu.string.getByteLength = function(a) {
	return String(a).replace(/[^\x00-\xff]/g, "ci").length
};
baidu.string.decodeHTML = function(a) {
	var b = String(a).replace(/&quot;/g, '"').replace(/&lt;/g, "<").replace(/&gt;/g, ">").replace(/&amp;/g, "&");
	return b.replace(/&#([\d]+);/g, function(d, c) {
		return String.fromCharCode(parseInt(c, 10))
	})
};
baidu.decodeHTML = baidu.string.decodeHTML;
baidu.string.format = function(c, a) {
	c = String(c);
	var b = Array.prototype.slice.call(arguments, 1),
		d = Object.prototype.toString;
	if (b.length) {
		b = b.length == 1 ? (a !== null && (/\[object Array\]|\[object Object\]/.test(d.call(a))) ? a : b) : b;return c.replace(/#\{(.+?)\}/g, function(f, h) {
			var g = b[h];
			if ("[object Function]" == d.call(g)) {
				g = g(h)
			}
			return ("undefined" == typeof g ? "" : g)
		})
	}
	return c
};
baidu.format = baidu.string.format;
baidu.string.wbr = function(a) {
	return String(a).replace(/(?:<[^>]+>)|(?:&#?[0-9a-z]{2,6};)|(.{1})/gi, "$&<wbr>").replace(/><wbr>/g, ">")
};
baidu.string.subByte = function(c, b, a) {
	c = String(c);
	a = a || "";
	if (b < 0 || baidu.string.getByteLength(c) <= b) {
		return c + a
	}
	c = c.substr(0, b).replace(/([^\x00-\xff])/g, "\x241 ").substr(0, b).replace(/[^\x00-\xff]$/, "").replace(/([^\x00-\xff]) /g, "\x241");return c + a
};
baidu.string.toHalfWidth = function(a) {
	return String(a).replace(/[\uFF01-\uFF5E]/g, function(b) {
		return String.fromCharCode(b.charCodeAt(0) - 65248)
	}).replace(/\u3000/g, " ")
};
baidu.page = baidu.page || {};
baidu.page.getHeight = function() {
	var d = document,
		a = d.body,
		c = d.documentElement,
		b = d.compatMode == "BackCompat" ? a : d.documentElement;
	return Math.max(c.scrollHeight, a.scrollHeight, b.clientHeight)
};
baidu.page.loadCssFile = function(b) {
	var a = document.createElement("link");
	a.setAttribute("rel", "stylesheet");a.setAttribute("type", "text/css");a.setAttribute("href", b);document.getElementsByTagName("head")[0].appendChild(a)
};
baidu.page.getScrollLeft = function() {
	var a = document;
	return window.pageXOffset || a.documentElement.scrollLeft || a.body.scrollLeft
};
baidu.page.getViewWidth = function() {
	var b = document,
		a = b.compatMode == "BackCompat" ? b.body : b.documentElement;
	return a.clientWidth
};
baidu.page.loadJsFile = function(b) {
	var a = document.createElement("script");
	a.setAttribute("type", "text/javascript");a.setAttribute("src", b);a.setAttribute("defer", "defer");document.getElementsByTagName("head")[0].appendChild(a)
};
baidu.page.getWidth = function() {
	var d = document,
		a = d.body,
		c = d.documentElement,
		b = d.compatMode == "BackCompat" ? a : d.documentElement;
	return Math.max(c.scrollWidth, a.scrollWidth, b.clientWidth)
};
baidu.page.getScrollTop = function() {
	var a = document;
	return window.pageYOffset || a.documentElement.scrollTop || a.body.scrollTop
};
baidu.page.getViewHeight = function() {
	var b = document,
		a = b.compatMode == "BackCompat" ? b.body : b.documentElement;
	return a.clientHeight
};
baidu.array.filter = function(j, g, d) {
	var c = [],
		b = 0,
		a = j.length,
		h,
		f;
	if ("function" == typeof g) {
		for (f = 0; f < a; f++) {
			h = j[f];
			if (true === g.call(d || j, h, f)) {
				c[b++] = h
			}
		}
	}
	return c
};
baidu.array.unique = function(f, g) {
	var b = f.length,
		a = f.slice(0),
		d,
		c;
	if ("function" != typeof g) {
		g = function(i, h) {
			return i === h
		}
	}
	while (--b > 0) {
		c = a[b];
		d = b;
		while (d--) {
			if (g(c, a[d])) {
				a.splice(b, 1);break
			}
		}
	}
	return a
};
baidu.array.indexOf = function(f, b, d) {
	var a = f.length,
		c = b;
	d = d | 0;
	if (d < 0) {
		d = Math.max(0, a + d)
	}
	for (; d < a; d++) {
		if (d in f && f[d] === b) {
			return d
		}
	}
	return -1
};
baidu.each = baidu.array.forEach = baidu.array.each = function(h, f, b) {
	var d,
		g,
		c,
		a = h.length;
	if ("function" == typeof f) {
		for (c = 0; c < a; c++) {
			g = h[c];
			d = f.call(b || h, g, c);
			if (d === false) {
				break
			}
		}
	}
	return h
};
baidu.array.find = function(f, c) {
	var d,
		b,
		a = f.length;
	if ("function" == typeof c) {
		for (b = 0; b < a; b++) {
			d = f[b];
			if (true === c.call(f, d, b)) {
				return d
			}
		}
	}
	return null
};
baidu.array.lastIndexOf = function(d, b, c) {
	var a = d.length;
	c = c | 0;
	if (!c || c >= a) {
		c = a - 1
	}
	if (c < 0) {
		c += a
	}
	for (; c >= 0; c--) {
		if (c in d && d[c] === b) {
			return c
		}
	}
	return -1
};
baidu.array.removeAt = function(b, a) {
	return b.splice(a, 1)[0]
};
baidu.lang.createClass = function(g, b) {
	b = b || {};
	var f = b.superClass || baidu.lang.Class;
	var d = function() {
		if (f != baidu.lang.Class) {
			f.apply(this, arguments)
		} else {
			f.call(this)
		}
		g.apply(this, arguments)
	};
	d.options = b.options || {};
	var j = function() {},
		h = g.prototype;
	j.prototype = f.prototype;
	var a = d.prototype = new j();
	for (var c in h) {
		a[c] = h[c]
	}
	typeof b.className == "string" && (a._className = b.className);
	a.constructor = h.constructor;
	d.extend = function(l) {
		for (var k in l) {
			d.prototype[k] = l[k]
		}
		return d
	};return d
};
baidu.lang.createSingle = function(b) {
	var d = new baidu.lang.Class();
	for (var a in b) {
		d[a] = b[a]
	}
	return d
};
baidu.string.filterFormat = function(c, a) {
	var b = Array.prototype.slice.call(arguments, 1),
		d = Object.prototype.toString;
	if (b.length) {
		b = b.length == 1 ? (a !== null && (/\[object Array\]|\[object Object\]/.test(d.call(a))) ? a : b) : b;return c.replace(/#\{(.+?)\}/g, function(g, k) {
			var m,
				j,
				h,
				f,
				l;
			if (!b) {
				return ""
			}
			m = k.split("|");
			j = b[m[0]];
			if ("[object Function]" == d.call(j)) {
				j = j(m[0])
			}
			for (h = 1, f = m.length; h < f; ++h) {
				l = baidu.string.filterFormat[m[h]];
				if ("[object Function]" == d.call(l)) {
					j = l(j)
				}
			}
			return (("undefined" == typeof j || j === null) ? "" : j)
		})
	}
	return c
};
baidu.string.filterFormat.escapeJs = function(f) {
	if (!f || "string" != typeof f) {
		return f
	}
	var d,
		a,
		b,
		c = [];
	for (d = 0, a = f.length; d < a; ++d) {
		b = f.charCodeAt(d);
		if (b > 255) {
			c.push(f.charAt(d))
		} else {
			c.push("\\x" + b.toString(16))
		}
	}
	return c.join("")
};
baidu.string.filterFormat.js = baidu.string.filterFormat.escapeJs;
baidu.string.filterFormat.escapeString = function(a) {
	if (!a || "string" != typeof a) {
		return a
	}
	return a.replace(/["'<>\\\/`]/g, function(b) {
		return "&#" + b.charCodeAt(0) + ";"
	})
};
baidu.string.filterFormat.e = baidu.string.filterFormat.escapeString;
baidu.string.filterFormat.toInt = function(a) {
	return parseInt(a, 10) || 0
};
baidu.string.filterFormat.i = baidu.string.filterFormat.toInt;(function() {
	baidu.page.getMousePosition = function() {
		return {
			x : baidu.page.getScrollLeft() + a.x,
			y : baidu.page.getScrollTop() + a.y
		}
	};
	var a = {
		x : 0,
		y : 0
	};
	baidu.event.on(document, "onmousemove", function(b) {
		b = window.event || b;
		a.x = b.clientX;
		a.y = b.clientY
	})
})();(function() {
	var n,
		m,
		h,
		f,
		q,
		i,
		r,
		a,
		p,
		g = baidu.lang.isFunction,
		d,
		k,
		c;
	baidu.dom.drag = function(t, s) {
		p = a = null;
		if (!(n = baidu.dom.g(t))) {
			return false
		}
		m = baidu.object.extend({
			autoStop : true,
			capture : true,
			interval : 20
		}, s);
		k = baidu.dom.getPosition(n.offsetParent);
		c = baidu.dom.getPosition(n);
		if (baidu.getStyle(n, "position") == "absolute") {
			q = c.top - (n.offsetParent == document.body ? 0 : k.top);
			i = c.left - (n.offsetParent == document.body ? 0 : k.left)
		} else {
			q = parseFloat(baidu.getStyle(n, "top")) || -parseFloat(baidu.getStyle(n, "bottom")) || 0;
			i = parseFloat(baidu.getStyle(n, "left")) || -parseFloat(baidu.getStyle(n, "right")) || 0
		}
		if (m.mouseEvent) {
			h = baidu.page.getScrollLeft() + m.mouseEvent.clientX;
			f = baidu.page.getScrollTop() + m.mouseEvent.clientY
		} else {
			var u = baidu.page.getMousePosition();
			h = u.x;
			f = u.y
		}
		d = setInterval(b, m.interval);m.autoStop && baidu.event.on(document, "mouseup", o);baidu.event.on(document.body, "selectstart", j);
		if (m.capture && n.setCapture) {
			n.setCapture()
		} else {
			if (m.capture && window.captureEvents) {
				window.captureEvents(Event.MOUSEMOVE | Event.MOUSEUP)
			}
		}
		r = document.body.style.MozUserSelect;
		document.body.style.MozUserSelect = "none";
		if (g(m.ondragstart)) {
			m.ondragstart(n, m)
		}
		return {
			stop : o,
			update : l
		}
	};
	function l(s) {
		baidu.extend(m, s)
	}
	function o() {
		clearTimeout(d);
		if (m.capture && n.releaseCapture) {
			n.releaseCapture()
		} else {
			if (m.capture && window.releaseEvents) {
				window.releaseEvents(Event.MOUSEMOVE | Event.MOUSEUP)
			}
		}
		document.body.style.MozUserSelect = r;baidu.event.un(document.body, "selectstart", j);m.autoStop && baidu.event.un(document, "mouseup", o);
		if (g(m.ondragend)) {
			m.ondragend(n, m)
		}
	}
	function b(w) {
		var s = m.range,
			v = baidu.page.getMousePosition(),
			t = i + v.x - h,
			u = q + v.y - f;
		if (typeof s == "object" && s && s.length == 4) {
			t = Math.max(s[3], t);
			t = Math.min(s[1] - n.offsetWidth, t);
			u = Math.max(s[0], u);
			u = Math.min(s[2] - n.offsetHeight, u)
		}
		n.style.top = u + "px";
		n.style.left = t + "px";
		if ((a !== t || p !== u) && (a !== null || p !== null)) {
			if (g(m.ondrag)) {
				m.ondrag(n, m)
			}
		}
		a = t;
		p = u
	}
	function j(s) {
		return baidu.event.preventDefault(s, false)
	}
})();
baidu.dom.draggable = function(b, l) {
	l = baidu.object.extend({
		toggle : function() {
			return true
		}
	}, l || {});
	l.autoStop = true;
	b = baidu.dom.g(b);
	l.handler = l.handler || b;
	var a,
		j = [ "ondragstart", "ondrag", "ondragend" ],
		c = j.length - 1,
		d,
		k,
		g = {
			dispose : function() {
				k && k.stop();baidu.event.un(l.handler, "onmousedown", h);baidu.lang.Class.prototype.dispose.call(g)
			}
		},
		f = this;
	if (a = baidu.dom.ddManager) {
		for (; c >= 0; c--) {
			d = j[c];
			l[d] = (function(i) {
				var m = l[i];
				return function() {
					baidu.lang.isFunction(m) && m.apply(f, arguments);a.dispatchEvent(i, {
						DOM : b
					})
				}
			})(d)
		}
	}
	if (b) {
		function h(m) {
			var i = l.mouseEvent = window.event || m;
			if (i.button > 1 || (baidu.lang.isFunction(l.toggle) && !l.toggle())) {
				return
			}
			if (baidu.dom.getStyle(b, "position") == "static") {
				baidu.dom.setStyle(b, "position", "relative")
			}
			if (baidu.lang.isFunction(l.onbeforedragstart)) {
				l.onbeforedragstart(b)
			}
			k = baidu.dom.drag(b, l);
			g.stop = k.stop;
			g.update = k.update;baidu.event.preventDefault(i)
		}
		baidu.event.on(l.handler, "onmousedown", h)
	}
	return {
		cancel : function() {
			g.dispose()
		}
	}
};
/*
 * Sizzle CSS Selector Engine - v1.0
 *  Copyright 2009, The Dojo Foundation
 *  Released under the MIT, BSD, and GPL Licenses.
 *  More information: http://sizzlejs.com/
 */
(function() {
	var q = /((?:\((?:\([^()]+\)|[^()]+)+\)|\[(?:\[[^\[\]]*\]|['"][^'"]*['"]|[^\[\]'"]+)+\]|\\.|[^ >+~,(\[\\]+)+|[>+~])(\s*,\s*)?((?:.|\r|\n)*)/g,
		j = 0,
		d = Object.prototype.toString,
		p = false,
		i = true;
	[ 0, 0 ].sort(function() {
		i = false;return 0
	});
	var b = function(x, s, A, B) {
		A = A || [];
		s = s || document;
		var D = s;
		if (s.nodeType !== 1 && s.nodeType !== 9) {
			return []
		}
		if (!x || typeof x !== "string") {
			return A
		}
		var u,
			F,
			I,
			t,
			E,
			H,
			G,
			z,
			w = true,
			v = b.isXML(s),
			y = [],
			C = x;
		do {
			q.exec("");
			u = q.exec(C);
			if (u) {
				C = u[3];y.push(u[1]);
				if (u[2]) {
					t = u[3];break
				}
			}
		} while (u);
		if (y.length > 1 && k.exec(x)) {
			if (y.length === 2 && f.relative[y[0]]) {
				F = h(y[0] + y[1], s)
			} else {
				F = f.relative[y[0]] ? [ s ] : b(y.shift(), s);
				while (y.length) {
					x = y.shift();
					if (f.relative[x]) {
						x += y.shift()
					}
					F = h(x, F)
				}
			}
		} else {
			if (!B && y.length > 1 && s.nodeType === 9 && !v && f.match.ID.test(y[0]) && !f.match.ID.test(y[y.length - 1])) {
				E = b.find(y.shift(), s, v);
				s = E.expr ? b.filter(E.expr, E.set)[0] : E.set[0]
			}
			if (s) {
				E = B ? {
					expr : y.pop(),
					set : a(B)
				} : b.find(y.pop(), y.length === 1 && (y[0] === "~" || y[0] === "+") && s.parentNode ? s.parentNode : s, v);
				F = E.expr ? b.filter(E.expr, E.set) : E.set;
				if (y.length > 0) {
					I = a(F)
				} else {
					w = false
				}
				while (y.length) {
					H = y.pop();
					G = H;
					if (!f.relative[H]) {
						H = ""
					} else {
						G = y.pop()
					}
					if (G == null) {
						G = s
					}
					f.relative[H](I, G, v)
				}
			} else {
				I = y = []
			}
		}
		if (!I) {
			I = F
		}
		if (!I) {
			b.error(H || x)
		}
		if (d.call(I) === "[object Array]") {
			if (!w) {
				A.push.apply(A, I)
			} else {
				if (s && s.nodeType === 1) {
					for (z = 0; I[z] != null; z++) {
						if (I[z] && (I[z] === true || I[z].nodeType === 1 && b.contains(s, I[z]))) {
							A.push(F[z])
						}
					}
				} else {
					for (z = 0; I[z] != null; z++) {
						if (I[z] && I[z].nodeType === 1) {
							A.push(F[z])
						}
					}
				}
			}
		} else {
			a(I, A)
		}
		if (t) {
			b(t, D, A, B);b.uniqueSort(A)
		}
		return A
	};
	b.uniqueSort = function(t) {
		if (c) {
			p = i;t.sort(c);
			if (p) {
				for (var s = 1; s < t.length; s++) {
					if (t[s] === t[s - 1]) {
						t.splice(s--, 1)
					}
				}
			}
		}
		return t
	};
	b.matches = function(s, t) {
		return b(s, null, null, t)
	};
	b.matchesSelector = function(s, t) {
		return b(t, null, null, [ s ]).length > 0
	};
	b.find = function(z, s, A) {
		var y;
		if (!z) {
			return []
		}
		for (var v = 0, u = f.order.length; v < u; v++) {
			var w,
				x = f.order[v];
			if( (w = f.leftMatch[x].exec(z)) ) {
				var t = w[1];
				w.splice(1, 1);
				if (t.substr(t.length - 1) !== "\\") {
					w[1] = (w[1] || "").replace(/\\/g, "");
					y = f.find[x](w, s, A);
					if (y != null) {
						z = z.replace(f.match[x], "");break
					}
				}
			}
		}
		if (!y) {
			y = s.getElementsByTagName("*")
		}
		return {
			set : y,
			expr : z
		}
	};
	b.filter = function(D, C, G, w) {
		var y,
			s,
			u = D,
			I = [],
			A = C,
			z = C && C[0] && b.isXML(C[0]);
		while (D && C.length) {
			for (var B in f.filter) {
				if ((y = f.leftMatch[B].exec(D)) != null && y[2]) {
					var H,
						F,
						t = f.filter[B],
						v = y[1];
					s = false;y.splice(1, 1);
					if (v.substr(v.length - 1) === "\\") {
						continue
					}
					if (A === I) {
						I = []
					}
					if (f.preFilter[B]) {
						y = f.preFilter[B](y, A, G, I, w, z);
						if (!y) {
							s = H = true
						} else {
							if (y === true) {
								continue
							}
						}
					}
					if (y) {
						for (var x = 0; (F = A[x]) != null; x++) {
							if (F) {
								H = t(F, y, x, A);
								var E = w ^ !!H;
								if (G && H != null) {
									if (E) {
										s = true
									} else {
										A[x] = false
									}
								} else {
									if (E) {
										I.push(F);
										s = true
									}
								}
							}
						}
					}
					if (H !== undefined) {
						if (!G) {
							A = I
						}
						D = D.replace(f.match[B], "");
						if (!s) {
							return []
						}
						break
					}
				}
			}
			if (D === u) {
				if (s == null) {
					b.error(D)
				} else {
					break
				}
			}
			u = D
		}
		return A
	};
	b.error = function(s) {
		throw "Syntax error, unrecognized expression: " + s
	};
	var f = b.selectors = {
		order : [ "ID", "NAME", "TAG" ],
		match : {
			ID : /#((?:[\w\u00c0-\uFFFF\-]|\\.)+)/,
			CLASS : /\.((?:[\w\u00c0-\uFFFF\-]|\\.)+)/,
			NAME : /\[name=['"]*((?:[\w\u00c0-\uFFFF\-]|\\.)+)['"]*\]/,
			ATTR : /\[\s*((?:[\w\u00c0-\uFFFF\-]|\\.)+)\s*(?:(\S?=)\s*(['"]*)(.*?)\3|)\s*\]/,
			TAG : /^((?:[\w\u00c0-\uFFFF\*\-]|\\.)+)/,
			CHILD : /:(only|nth|last|first)-child(?:\(\s*(even|odd|(?:[+\-]?\d+|(?:[+\-]?\d*)?n\s*(?:[+\-]\s*\d+)?))\s*\))?/,
			POS : /:(nth|eq|gt|lt|first|last|even|odd)(?:\((\d*)\))?(?=[^\-]|$)/,
			PSEUDO : /:((?:[\w\u00c0-\uFFFF\-]|\\.)+)(?:\((['"]?)((?:\([^\)]+\)|[^\(\)]*)+)\2\))?/
		},
		leftMatch : {},
		attrMap : {
			"class" : "className",
			"for" : "htmlFor"
		},
		attrHandle : {
			href : function(s) {
				return s.getAttribute("href")
			}
		},
		relative : {
			"+" : function(y, t) {
				var v = typeof t === "string",
					x = v && !/\W/.test(t),
					z = v && !x;
				if (x) {
					t = t.toLowerCase()
				}
				for (var u = 0, s = y.length, w; u < s; u++) {
					if( (w = y[u]) ) {
						while ((w = w.previousSibling) && w.nodeType !== 1) {
						}
						y[u] = z || w && w.nodeName.toLowerCase() === t ? w || false : w === t
					}
				}
				if (z) {
					b.filter(t, y, true)
				}
			},
			">" : function(y, t) {
				var x,
					w = typeof t === "string",
					u = 0,
					s = y.length;
				if (w && !/\W/.test(t)) {
					t = t.toLowerCase();
					for (; u < s; u++) {
						x = y[u];
						if (x) {
							var v = x.parentNode;
							y[u] = v.nodeName.toLowerCase() === t ? v : false
						}
					}
				} else {
					for (; u < s; u++) {
						x = y[u];
						if (x) {
							y[u] = w ? x.parentNode : x.parentNode === t
						}
					}
					if (w) {
						b.filter(t, y, true)
					}
				}
			},
			"" : function(v, t, x) {
				var w,
					u = j++,
					s = r;
				if (typeof t === "string" && !/\W/.test(t)) {
					t = t.toLowerCase();
					w = t;
					s = o
				}
				s("parentNode", t, u, v, w, x)
			},
			"~" : function(v, t, x) {
				var w,
					u = j++,
					s = r;
				if (typeof t === "string" && !/\W/.test(t)) {
					t = t.toLowerCase();
					w = t;
					s = o
				}
				s("previousSibling", t, u, v, w, x)
			}
		},
		find : {
			ID : function(t, u, v) {
				if (typeof u.getElementById !== "undefined" && !v) {
					var s = u.getElementById(t[1]);
					return s && s.parentNode ? [ s ] : []
				}
			},
			NAME : function(u, x) {
				if (typeof x.getElementsByName !== "undefined") {
					var t = [],
						w = x.getElementsByName(u[1]);
					for (var v = 0, s = w.length; v < s; v++) {
						if (w[v].getAttribute("name") === u[1]) {
							t.push(w[v])
						}
					}
					return t.length === 0 ? null : t
				}
			},
			TAG : function(s, t) {
				return t.getElementsByTagName(s[1])
			}
		},
		preFilter : {
			CLASS : function(v, t, u, s, y, z) {
				v = " " + v[1].replace(/\\/g, "") + " ";
				if (z) {
					return v
				}
				for (var w = 0, x; (x = t[w]) != null; w++) {
					if (x) {
						if (y ^ (x.className && (" " + x.className + " ").replace(/[\t\n\r]/g, " ").indexOf(v) >= 0)) {
							if (!u) {
								s.push(x)
							}
						} else {
							if (u) {
								t[w] = false
							}
						}
					}
				}
				return false
			},
			ID : function(s) {
				return s[1].replace(/\\/g, "")
			},
			TAG : function(t, s) {
				return t[1].toLowerCase()
			},
			CHILD : function(s) {
				if (s[1] === "nth") {
					if (!s[2]) {
						b.error(s[0])
					}
					s[2] = s[2].replace(/^\+|\s*/g, "");
					var t = /(-?)(\d*)(?:n([+\-]?\d*))?/.exec(s[2] === "even" && "2n" || s[2] === "odd" && "2n+1" || !/\D/.test(s[2]) && "0n+" + s[2] || s[2]);
					s[2] = (t[1] + (t[2] || 1)) - 0;
					s[3] = t[3] - 0
				} else {
					if (s[2]) {
						b.error(s[0])
					}
				}
				s[0] = j++;return s
			},
			ATTR : function(w, t, u, s, x, y) {
				var v = w[1].replace(/\\/g, "");
				if (!y && f.attrMap[v]) {
					w[1] = f.attrMap[v]
				}
				if (w[2] === "~=") {
					w[4] = " " + w[4] + " "
				}
				return w
			},
			PSEUDO : function(w, t, u, s, x) {
				if (w[1] === "not") {
					if ((q.exec(w[3]) || "").length > 1 || /^\w/.test(w[3])) {
						w[3] = b(w[3], null, null, t)
					} else {
						var v = b.filter(w[3], t, u, true ^ x);
						if (!u) {
							s.push.apply(s, v)
						}
						return false
					}
				} else {
					if (f.match.POS.test(w[0]) || f.match.CHILD.test(w[0])) {
						return true
					}
				}
				return w
			},
			POS : function(s) {
				s.unshift(true);return s
			}
		},
		filters : {
			enabled : function(s) {
				return s.disabled === false && s.type !== "hidden"
			},
			disabled : function(s) {
				return s.disabled === true
			},
			checked : function(s) {
				return s.checked === true
			},
			selected : function(s) {
				s.parentNode.selectedIndex;return s.selected === true
			},
			parent : function(s) {
				return !!s.firstChild
			},
			empty : function(s) {
				return !s.firstChild
			},
			has : function(u, t, s) {
				return !!b(s[3], u).length
			},
			header : function(s) {
				return (/h\d/i).test(s.nodeName)
			},
			text : function(s) {
				return "text" === s.type
			},
			radio : function(s) {
				return "radio" === s.type
			},
			checkbox : function(s) {
				return "checkbox" === s.type
			},
			file : function(s) {
				return "file" === s.type
			},
			password : function(s) {
				return "password" === s.type
			},
			submit : function(s) {
				return "submit" === s.type
			},
			image : function(s) {
				return "image" === s.type
			},
			reset : function(s) {
				return "reset" === s.type
			},
			button : function(s) {
				return "button" === s.type || s.nodeName.toLowerCase() === "button"
			},
			input : function(s) {
				return (/input|select|textarea|button/i).test(s.nodeName)
			}
		},
		setFilters : {
			first : function(t, s) {
				return s === 0
			},
			last : function(u, t, s, v) {
				return t === v.length - 1
			},
			even : function(t, s) {
				return s % 2 === 0
			},
			odd : function(t, s) {
				return s % 2 === 1
			},
			lt : function(u, t, s) {
				return t < s[3] - 0
			},
			gt : function(u, t, s) {
				return t > s[3] - 0
			},
			nth : function(u, t, s) {
				return s[3] - 0 === t
			},
			eq : function(u, t, s) {
				return s[3] - 0 === t
			}
		},
		filter : {
			PSEUDO : function(u, z, y, A) {
				var s = z[1],
					t = f.filters[s];
				if (t) {
					return t(u, y, z, A)
				} else {
					if (s === "contains") {
						return (u.textContent || u.innerText || b.getText([ u ]) || "").indexOf(z[3]) >= 0
					} else {
						if (s === "not") {
							var v = z[3];
							for (var x = 0, w = v.length; x < w; x++) {
								if (v[x] === u) {
									return false
								}
							}
							return true
						} else {
							b.error(s)
						}
					}
				}
			},
			CHILD : function(s, v) {
				var y = v[1],
					t = s;
				switch (y) {
				case "only":
				case "first":
					while ((t = t.previousSibling)) {
						if (t.nodeType === 1) {
							return false
						}
					}
					if (y === "first") {
						return true
					}
					t = s;case "last":
					while ((t = t.nextSibling)) {
						if (t.nodeType === 1) {
							return false
						}
					}
					return true;case "nth":
					var u = v[2],
						B = v[3];
					if (u === 1 && B === 0) {
						return true
					}
					var x = v[0],
						A = s.parentNode;
					if (A && (A.sizcache !== x || !s.nodeIndex)) {
						var w = 0;
						for (t = A.firstChild; t; t = t.nextSibling) {
							if (t.nodeType === 1) {
								t.nodeIndex = ++w
							}
						}
						A.sizcache = x
					}
					var z = s.nodeIndex - B;
					if (u === 0) {
						return z === 0
					} else {
						return (z % u === 0 && z / u >= 0)
					}
				}
			},
			ID : function(t, s) {
				return t.nodeType === 1 && t.getAttribute("id") === s
			},
			TAG : function(t, s) {
				return (s === "*" && t.nodeType === 1) || t.nodeName.toLowerCase() === s
			},
			CLASS : function(t, s) {
				return (" " + (t.className || t.getAttribute("class")) + " ").indexOf(s) > -1
			},
			ATTR : function(x, v) {
				var u = v[1],
					s = f.attrHandle[u] ? f.attrHandle[u](x) : x[u] != null ? x[u] : x.getAttribute(u),
					y = s + "",
					w = v[2],
					t = v[4];
				return s == null ? w === "!=" : w === "=" ? y === t : w === "*=" ? y.indexOf(t) >= 0 : w === "~=" ? (" " + y + " ").indexOf(t) >= 0 : !t ? y && s !== false : w === "!=" ? y !== t : w === "^=" ? y.indexOf(t) === 0 : w === "$=" ? y.substr(y.length - t.length) === t : w === "|=" ? y === t || y.substr(0, t.length + 1) === t + "-" : false
			},
			POS : function(w, t, u, x) {
				var s = t[2],
					v = f.setFilters[s];
				if (v) {
					return v(w, u, t, x)
				}
			}
		}
	};
	var k = f.match.POS,
		g = function(t, s) {
			return "\\" + (s - 0 + 1)
		};
	for (var n in f.match) {
		f.match[n] = new RegExp(f.match[n].source + (/(?![^\[]*\])(?![^\(]*\))/.source));
		f.leftMatch[n] = new RegExp(/(^(?:.|\r|\n)*?)/.source + f.match[n].source.replace(/\\(\d+)/g, g))
	}
	var a = function(t, s) {
		t = Array.prototype.slice.call(t, 0);
		if (s) {
			s.push.apply(s, t);return s
		}
		return t
	};
	try {
		Array.prototype.slice.call(document.documentElement.childNodes, 0)[0].nodeType
	} catch (l) {
		a = function(w, v) {
			var u = 0,
				t = v || [];
			if (d.call(w) === "[object Array]") {
				Array.prototype.push.apply(t, w)
			} else {
				if (typeof w.length === "number") {
					for (var s = w.length; u < s; u++) {
						t.push(w[u])
					}
				} else {
					for (; w[u]; u++) {
						t.push(w[u])
					}
				}
			}
			return t
		}
	}
	var c,
		m;
	if (document.documentElement.compareDocumentPosition) {
		c = function(t, s) {
			if (t === s) {
				p = true;return 0
			}
			if (!t.compareDocumentPosition || !s.compareDocumentPosition) {
				return t.compareDocumentPosition ? -1 : 1
			}
			return t.compareDocumentPosition(s) & 4 ? -1 : 1
		}
	} else {
		c = function(A, z) {
			var x,
				t,
				u = [],
				s = [],
				w = A.parentNode,
				y = z.parentNode,
				B = w;
			if (A === z) {
				p = true;return 0
			} else {
				if (w === y) {
					return m(A, z)
				} else {
					if (!w) {
						return -1
					} else {
						if (!y) {
							return 1
						}
					}
				}
			}
			while (B) {
				u.unshift(B);
				B = B.parentNode
			}
			B = y;
			while (B) {
				s.unshift(B);
				B = B.parentNode
			}
			x = u.length;
			t = s.length;
			for (var v = 0; v < x && v < t; v++) {
				if (u[v] !== s[v]) {
					return m(u[v], s[v])
				}
			}
			return v === x ? m(A, s[v], -1) : m(u[v], z, 1)
		};
		m = function(t, s, u) {
			if (t === s) {
				return u
			}
			var v = t.nextSibling;
			while (v) {
				if (v === s) {
					return -1
				}
				v = v.nextSibling
			}
			return 1
		}
	}
	b.getText = function(s) {
		var t = "",
			v;
		for (var u = 0; s[u]; u++) {
			v = s[u];
			if (v.nodeType === 3 || v.nodeType === 4) {
				t += v.nodeValue
			} else {
				if (v.nodeType !== 8) {
					t += b.getText(v.childNodes)
				}
			}
		}
		return t
	};(function() {
		var t = document.createElement("div"),
			u = "script" + (new Date()).getTime(),
			s = document.documentElement;
		t.innerHTML = "<a name='" + u + "'/>";s.insertBefore(t, s.firstChild);
		if (document.getElementById(u)) {
			f.find.ID = function(w, x, y) {
				if (typeof x.getElementById !== "undefined" && !y) {
					var v = x.getElementById(w[1]);
					return v ? v.id === w[1] || typeof v.getAttributeNode !== "undefined" && v.getAttributeNode("id").nodeValue === w[1] ? [ v ] : undefined : []
				}
			};
			f.filter.ID = function(x, v) {
				var w = typeof x.getAttributeNode !== "undefined" && x.getAttributeNode("id");
				return x.nodeType === 1 && w && w.nodeValue === v
			}
		}
		s.removeChild(t);
		s = t = null
	})();(function() {
		var t = document.createElement("div");
		try {
			t.appendChild(document.createComment(""))
		} catch (s) {}
		if (t.getElementsByTagName("*").length > 0) {
			f.find.TAG = function(u, y) {
				var x = y.getElementsByTagName(u[1]);
				if (u[1] === "*") {
					var w = [];
					for (var v = 0; x[v]; v++) {
						if (x[v].nodeType === 1) {
							w.push(x[v])
						}
					}
					x = w
				}
				return x
			}
		}
		t.innerHTML = "<a href='#'></a>";
		if (t.firstChild && typeof t.firstChild.getAttribute !== "undefined" && t.firstChild.getAttribute("href") !== "#") {
			f.attrHandle.href = function(u) {
				return u.getAttribute("href", 2)
			}
		}
		t = null
	})();
	if (document.querySelectorAll) {
		(function() {
			var s = b,
				v = document.createElement("div"),
				u = "__sizzle__";
			v.innerHTML = "<p class='TEST'></p>";
			if (v.querySelectorAll && v.querySelectorAll(".TEST").length === 0) {
				return
			}
			b = function(D, x, z, C) {
				x = x || document;
				D = D.replace(/\=\s*([^'"\]]*)\s*\]/g, "='$1']");
				if (!C && !b.isXML(x)) {
					if (x.nodeType === 9) {
						try {
							return a(x.querySelectorAll(D), z)
						} catch (A) {}
					} else {
						if (x.nodeType === 1 && x.nodeName.toLowerCase() !== "object") {
							var y = x.getAttribute("id"),
								w = y || u,
								F = x.parentNode,
								E = /^\s*[+~]/.test(D);
							if (!y) {
								x.setAttribute("id", w)
							} else {
								w = w.replace(/'/g, "\\$&")
							}
							if (E && F) {
								x = x.parentNode
							}
							try {
								if (!E || F) {
									return a(x.querySelectorAll("[id='" + w + "'] " + D), z)
								}
							} catch (B) {} finally {
								if (!y) {
									x.removeAttribute("id")
								}
							}
						}
					}
				}
				return s(D, x, z, C)
			};
			for (var t in s) {
				b[t] = s[t]
			}
			v = null
		})()
	}
	(function() {
		var s = document.documentElement,
			u = s.matchesSelector || s.mozMatchesSelector || s.webkitMatchesSelector || s.msMatchesSelector,
			t = false;
		try {
			u.call(document.documentElement, "[test!='']:sizzle")
		} catch (v) {
			t = true
		}
		if (u) {
			b.matchesSelector = function(w, y) {
				y = y.replace(/\=\s*([^'"\]]*)\s*\]/g, "='$1']");
				if (!b.isXML(w)) {
					try {
						if (t || !f.match.PSEUDO.test(y) && !/!=/.test(y)) {
							return u.call(w, y)
						}
					} catch (x) {}
				}
				return b(y, null, null, [ w ]).length > 0
			}
		}
	})();(function() {
		var s = document.createElement("div");
		s.innerHTML = "<div class='test e'></div><div class='test'></div>";
		if (!s.getElementsByClassName || s.getElementsByClassName("e").length === 0) {
			return
		}
		s.lastChild.className = "e";
		if (s.getElementsByClassName("e").length === 1) {
			return
		}
		f.order.splice(1, 0, "CLASS");
		f.find.CLASS = function(t, u, v) {
			if (typeof u.getElementsByClassName !== "undefined" && !v) {
				return u.getElementsByClassName(t[1])
			}
		};
		s = null
	})();
	function o(t, y, x, B, z, A) {
		for (var v = 0, u = B.length; v < u; v++) {
			var s = B[v];
			if (s) {
				var w = false;
				s = s[t];
				while (s) {
					if (s.sizcache === x) {
						w = B[s.sizset];break
					}
					if (s.nodeType === 1 && !A) {
						s.sizcache = x;
						s.sizset = v
					}
					if (s.nodeName.toLowerCase() === y) {
						w = s;break
					}
					s = s[t]
				}
				B[v] = w
			}
		}
	}
	function r(t, y, x, B, z, A) {
		for (var v = 0, u = B.length; v < u; v++) {
			var s = B[v];
			if (s) {
				var w = false;
				s = s[t];
				while (s) {
					if (s.sizcache === x) {
						w = B[s.sizset];break
					}
					if (s.nodeType === 1) {
						if (!A) {
							s.sizcache = x;
							s.sizset = v
						}
						if (typeof y !== "string") {
							if (s === y) {
								w = true;break
							}
						} else {
							if (b.filter(y, [ s ]).length > 0) {
								w = s;break
							}
						}
					}
					s = s[t]
				}
				B[v] = w
			}
		}
	}
	if (document.documentElement.contains) {
		b.contains = function(t, s) {
			return t !== s && (t.contains ? t.contains(s) : true)
		}
	} else {
		if (document.documentElement.compareDocumentPosition) {
			b.contains = function(t, s) {
				return !!(t.compareDocumentPosition(s) & 16)
			}
		} else {
			b.contains = function() {
				return false
			}
		}
	}
	b.isXML = function(s) {
		var t = (s ? s.ownerDocument || s : 0).documentElement;
		return t ? t.nodeName !== "HTML" : false
	};
	var h = function(s, z) {
		var x,
			v = [],
			w = "",
			u = z.nodeType ? [ z ] : z;
		while ((x = f.match.PSEUDO.exec(s))) {
			w += x[0];
			s = s.replace(f.match.PSEUDO, "")
		}
		s = f.relative[s] ? s + "*" : s;
		for (var y = 0, t = u.length; y < t; y++) {
			b(s, u[y], v)
		}
		return b.filter(w, v)
	};
	baidu.dom.query = b
})();
baidu.page.createStyleSheet = function(a) {
	var g = a || {},
		d = g.document || document,
		c;
	if (baidu.browser.ie) {
		if (!g.url) {
			g.url = ""
		}
		return d.createStyleSheet(g.url, g.index)
	} else {
		c = "<style type='text/css'></style>";g.url && (c = "<link type='text/css' rel='stylesheet' href='" + g.url + "'/>");baidu.dom.insertHTML(d.getElementsByTagName("HEAD")[0], "beforeEnd", c);
		if (g.url) {
			return null
		}
		var b = d.styleSheets[d.styleSheets.length - 1],
			f = b.rules || b.cssRules;
		return {
			self : b,
			rules : b.rules || b.cssRules,
			addRule : function(h, k, j) {
				if (b.addRule) {
					return b.addRule(h, k, j)
				} else {
					if (b.insertRule) {
						isNaN(j) && (j = f.length);return b.insertRule(h + "{" + k + "}", j)
					}
				}
			},
			removeRule : function(h) {
				if (b.removeRule) {
					b.removeRule(h)
				} else {
					if (b.deleteRule) {
						isNaN(h) && (h = 0);b.deleteRule(h)
					}
				}
			}
		}
	}
};
baidu.dom.create = function(c, a) {
	var d = document.createElement(c),
		b = a || {};
	return baidu.dom.setAttrs(d, b)
};
baidu.dom.empty = function(a) {
	a = baidu.dom.g(a);
	while (a.firstChild) {
		a.removeChild(a.firstChild)
	}
	return a
};
baidu.dom.getText = function(d) {
	var b = "",
		f,
		c = 0,
		a;
	d = baidu._g(d);
	if (d.nodeType === 3 || d.nodeType === 4) {
		b += d.nodeValue
	} else {
		if (d.nodeType !== 8) {
			f = d.childNodes;
			for (a = f.length; c < a; c++) {
				b += baidu.dom.getText(f[c])
			}
		}
	}
	return b
};
baidu.dom.hasAttr = function(c, b) {
	c = baidu.g(c);
	var a = c.attributes.getNamedItem(b);
	return !!(a && a.specified)
};
baidu.dom.toggleClass = function(a, b) {
	if (baidu.dom.hasClass(a, b)) {
		baidu.dom.removeClass(a, b)
	} else {
		baidu.dom.addClass(a, b)
	}
};
baidu.fn.methodize = function(b, a) {
	return function() {
		return b.apply(this, [ (a ? this[a] : this) ].concat([].slice.call(arguments)))
	}
};
baidu.fn.wrapReturnValue = function(a, c, b) {
	b = b | 0;return function() {
		var d = a.apply(this, arguments);
		if (b > 0) {
			return new c(arguments[b - 1])
		}
		if (!b) {
			return new c(d)
		}
		return d
	}
};
baidu.fn.multize = function(c, a) {
	var b = function() {
		var l = arguments[0],
			h = a ? b : c,
			f = [],
			k = [].slice.call(arguments, 0),
			g = 0,
			d,
			j;
		if (l instanceof Array) {
			for (d = l.length; g < d; g++) {
				k[0] = l[g];
				j = h.apply(this, k);f.push(j)
			}
			return f
		} else {
			return c.apply(this, arguments)
		}
	};
	return b
};
baidu.element = baidu.e = function(b) {
	var a = baidu._g(b);
	if (!a && baidu.dom.query) {
		a = baidu.dom.query(b)
	}
	return new baidu.element.Element(a)
};
baidu.element.Element = function(a) {
	if (!baidu.element._init) {
		baidu.element._makeChain();
		baidu.element._init = true
	}
	this._dom = baidu.lang.toArray(a)
};
baidu.element.Element.prototype.each = function(a) {
	baidu.array.each(this._dom, function(b) {
		a.call(this, new baidu.element.Element(b))
	})
};
baidu.element._toChainFunction = function(b, a) {
	return baidu.fn.methodize(baidu.fn.wrapReturnValue(baidu.fn.multize(b), baidu.element.Element, a), "_dom")
};
baidu.element._makeChain = function() {
	var b = baidu.element.Element.prototype,
		c = baidu.element._toChainFunction;
	baidu.each(("draggable droppable resizable").split(" "), function(d) {
		b[d] = c(baidu.dom[d], 1)
	});baidu.each(("remove getText contains getAttr getPosition getStyle hasClass intersect hasAttr getComputedStyle").split(" "), function(d) {
		b[d] = b[d.replace(/^get[A-Z]/g, a)] = c(baidu.dom[d], -1)
	});baidu.each(("addClass empty hide show insertAfter insertBefore insertHTML removeClass setAttr setAttrs setStyle setStyles show toggleClass toggle children next first getAncestorByClass getAncestorBy getAncestorByTag getDocument getParent getWindow last next prev g q query removeStyle setBorderBoxSize setOuterWidth setOuterHeight setBorderBoxWidth setBorderBoxHeight setPosition").split(" "), function(d) {
		b[d] = b[d.replace(/^get[A-Z]/g, a)] = c(baidu.dom[d], 0)
	});baidu.each(("on un").split(" "), function(d) {
		b[d] = c(baidu.event[d], 0)
	});baidu.each(("blur focus focusin focusout load resize scroll unload click dblclick mousedown mouseup mousemove mouseover mouseout mouseenter mouseleave change select submit keydown keypress keyup error").split(" "), function(d) {
		b[d] = function(f) {
			return this.on(d, f)
		}
	});
	function a(d) {
		return d.charAt(3).toLowerCase()
	}
};
baidu.lang.Class.prototype.addEventListeners = function(c, d) {
	if (typeof d == "undefined") {
		for (var b in c) {
			this.addEventListener(b, c[b])
		}
	} else {
		c = c.split(",");
		var b = 0,
			a = c.length,
			f;
		for (; b < a; b++) {
			this.addEventListener(baidu.trim(c[b]), d)
		}
	}
};
baidu.array.hash = function(f, b) {
	var g = {},
		d = b && b.length,
		c = 0,
		a = f.length;
	for (; c < a; c++) {
		g[f[c]] = (d && d > c) ? b[c] : true
	}
	return g
};
baidu.dom.ddManager = baidu.lang.createSingle({
	_targetsDroppingOver : {}
});
baidu.dom.droppable = function(f, c) {
	c = c || {};
	var d = baidu.dom.ddManager,
		h = baidu.dom.g(f),
		b = baidu.lang.guid(),
		g = function(k) {
			var j = d._targetsDroppingOver,
				i = {
					trigger : k.DOM,
					reciever : h
				};
			if (baidu.dom.intersect(h, k.DOM)) {
				if (!j[b]) {
					(typeof c.ondropover == "function") && c.ondropover.call(h, i);d.dispatchEvent("ondropover", i);
					j[b] = true
				}
			} else {
				if (j[b]) {
					(typeof c.ondropout == "function") && c.ondropout.call(h, i);d.dispatchEvent("ondropout", i)
				}
				delete j[b]
			}
		},
		a = function(j) {
			var i = {
				trigger : j.DOM,
				reciever : h
			};
			if (baidu.dom.intersect(h, j.DOM)) {
				typeof c.ondrop == "function" && c.ondrop.call(h, i);d.dispatchEvent("ondrop", i)
			}
			delete d._targetsDroppingOver[b]
		};
	d.addEventListener("ondrag", g);d.addEventListener("ondragend", a);return {
		cancel : function() {
			d.removeEventListener("ondrag", g);d.removeEventListener("ondragend", a)
		}
	}
};
baidu.dom.removeStyle = function() {
	var b = document.createElement("DIV"),
		a,
		c = baidu.dom._g;
	if (b.style.removeProperty) {
		a = function(f, d) {
			f = c(f);f.style.removeProperty(d);return f
		}
	} else {
		if (b.style.removeAttribute) {
			a = function(f, d) {
				f = c(f);f.style.removeAttribute(baidu.string.toCamelCase(d));return f
			}
		}
	}
	b = null;return a
}();
baidu.dom.setBorderBoxSize = function(c, b) {
	var a = {};
	b.width && (a.width = parseFloat(b.width));b.height && (a.height = parseFloat(b.height));
	function d(g, f) {
		return parseFloat(baidu.getStyle(g, f)) || 0
	}
	if (baidu.browser.isStrict) {
		if (b.width) {
			a.width = parseFloat(b.width) - d(c, "paddingLeft") - d(c, "paddingRight") - d(c, "borderLeftWidth") - d(c, "borderRightWidth");a.width < 0 && (a.width = 0)
		}
		if (b.height) {
			a.height = parseFloat(b.height) - d(c, "paddingTop") - d(c, "paddingBottom") - d(c, "borderTopWidth") - d(c, "borderBottomWidth");a.height < 0 && (a.height = 0)
		}
	}
	return baidu.dom.setStyles(c, a)
};
baidu.dom.setOuterHeight = baidu.dom.setBorderBoxHeight = function(b, a) {
	return baidu.dom.setBorderBoxSize(b, {
		height : a
	})
};
baidu.dom.setOuterWidth = baidu.dom.setBorderBoxWidth = function(a, b) {
	return baidu.dom.setBorderBoxSize(a, {
		width : b
	})
};
baidu.dom.resizable = function(d, h) {
	var z,
		m,
		j = {},
		c,
		a = {},
		r,
		x,
		u,
		b,
		f,
		k,
		o,
		s = false,
		v = {
			direction : [ "e", "s", "se" ],
			minWidth : 16,
			minHeight : 16,
			classPrefix : "tangram",
			directionHandlePosition : {}
		};
	if (!(z = baidu.dom.g(d)) && baidu.getStyle(z, "position") == "static") {
		return false
	}
	b = z.offsetParent;
	var n = baidu.getStyle(z, "position");
	m = baidu.extend(v, h);baidu.each([ "minHeight", "minWidth", "maxHeight", "maxWidth" ], function(A) {
		m[A] && (m[A] = parseFloat(m[A]))
	});
	r = [ m.minWidth || 0, m.maxWidth || Number.MAX_VALUE, m.minHeight || 0, m.maxHeight || Number.MAX_VALUE ];y();
	function y() {
		k = baidu.extend({
			e : {
				right : "-5px",
				top : "0px",
				width : "7px",
				height : z.offsetHeight
			},
			s : {
				left : "0px",
				bottom : "-5px",
				height : "7px",
				width : z.offsetWidth
			},
			n : {
				left : "0px",
				top : "-5px",
				height : "7px",
				width : z.offsetWidth
			},
			w : {
				left : "-5px",
				top : "0px",
				height : z.offsetHeight,
				width : "7px"
			},
			se : {
				right : "1px",
				bottom : "1px",
				height : "16px",
				width : "16px"
			},
			sw : {
				left : "1px",
				bottom : "1px",
				height : "16px",
				width : "16px"
			},
			ne : {
				right : "1px",
				top : "1px",
				height : "16px",
				width : "16px"
			},
			nw : {
				left : "1px",
				top : "1px",
				height : "16px",
				width : "16px"
			}
		}, m.directionHandlePosition);baidu.each(m.direction, function(A) {
			var B = m.classPrefix.split(" ");
			B[0] = B[0] + "-resizable-" + A;
			var D = baidu.dom.create("div", {
					className : B.join(" ")
				}),
				C = k[A];
			C.cursor = A + "-resize";
			C.position = "absolute";baidu.setStyles(D, C);
			D.key = A;
			D.style.MozUserSelect = "none";z.appendChild(D);
			j[A] = D;baidu.on(D, "mousedown", i)
		});
		s = false
	}
	function g() {
		f && t();baidu.object.each(j, function(A) {
			baidu.un(A, "mousedown", i);baidu.dom.remove(A)
		});
		s = true
	}
	function l(A) {
		if (!s) {
			m = baidu.extend(m, A || {});g();y()
		}
	}
	function i(C) {
		var B = baidu.event.getTarget(C),
			A = B.key;
		f = B;
		if (B.setCapture) {
			B.setCapture()
		} else {
			if (window.captureEvents) {
				window.captureEvents(Event.MOUSEMOVE | Event.MOUSEUP)
			}
		}
		u = baidu.getStyle(document.body, "cursor");baidu.setStyle(document.body, "cursor", A + "-resize");baidu.on(document, "mouseup", t);baidu.on(document.body, "selectstart", p);
		x = document.body.style.MozUserSelect;
		document.body.style.MozUserSelect = "none";var D = baidu.page.getMousePosition();
		a = q();
		o = setInterval(function() {
			w(A, D)
		}, 20);baidu.lang.isFunction(m.onresizestart) && m.onresizestart();baidu.event.preventDefault(C)
	}
	function t() {
		if (f.releaseCapture) {
			f.releaseCapture()
		} else {
			if (window.releaseEvents) {
				window.releaseEvents(Event.MOUSEMOVE | Event.MOUSEUP)
			}
		}
		baidu.un(document, "mouseup", t);baidu.un(document, "selectstart", p);
		document.body.style.MozUserSelect = x;baidu.un(document.body, "selectstart", p);clearInterval(o);baidu.setStyle(document.body, "cursor", u);
		f = null;baidu.lang.isFunction(m.onresizeend) && m.onresizeend()
	}
	function w(B, H) {
		var G = baidu.page.getMousePosition(),
			C = a.width,
			A = a.height,
			F = a.top,
			E = a.left,
			D;
		if (B.indexOf("e") >= 0) {
			C = Math.max(G.x - H.x + a.width, r[0]);
			C = Math.min(C, r[1])
		} else {
			if (B.indexOf("w") >= 0) {
				C = Math.max(H.x - G.x + a.width, r[0]);
				C = Math.min(C, r[1]);
				E -= C - a.width
			}
		}
		if (B.indexOf("s") >= 0) {
			A = Math.max(G.y - H.y + a.height, r[2]);
			A = Math.min(A, r[3])
		} else {
			if (B.indexOf("n") >= 0) {
				A = Math.max(H.y - G.y + a.height, r[2]);
				A = Math.min(A, r[3]);
				F -= A - a.height
			}
		}
		D = {
			width : C,
			height : A,
			top : F,
			left : E
		};baidu.dom.setOuterHeight(z, A);baidu.dom.setOuterWidth(z, C);baidu.setStyles(z, {
			top : F,
			left : E
		});j.n && baidu.setStyle(j.n, "width", C);j.s && baidu.setStyle(j.s, "width", C);j.e && baidu.setStyle(j.e, "height", A);j.w && baidu.setStyle(j.w, "height", A);baidu.lang.isFunction(m.onresize) && m.onresize({
			current : D,
			original : a
		})
	}
	function p(A) {
		return baidu.event.preventDefault(A, false)
	}
	function q() {
		var A = baidu.dom.getPosition(z.offsetParent),
			B = baidu.dom.getPosition(z),
			D,
			C;
		if (n == "absolute") {
			D = B.top - (z.offsetParent == document.body ? 0 : A.top);
			C = B.left - (z.offsetParent == document.body ? 0 : A.left)
		} else {
			D = parseFloat(baidu.getStyle(z, "top")) || -parseFloat(baidu.getStyle(z, "bottom")) || 0;
			C = parseFloat(baidu.getStyle(z, "left")) || -parseFloat(baidu.getStyle(z, "right")) || 0
		}
		baidu.setStyles(z, {
			top : D,
			left : C
		});return {
			width : z.offsetWidth,
			height : z.offsetHeight,
			top : D,
			left : C
		}
	}
	return {
		cancel : g,
		update : l,
		enable : y
	}
};
baidu.fn.bind = function(b, a) {
	var c = arguments.length > 2 ? [].slice.call(arguments, 2) : null;
	return function() {
		var f = baidu.lang.isString(b) ? a[b] : b,
			d = (c) ? c.concat([].slice.call(arguments, 0)) : arguments;
		return f.apply(a || f, d)
	}
};
baidu.lang.isBoolean = function(a) {
	return typeof a === "boolean"
};
baidu.lang.isDate = function(a) {
	return {}.toString.call(a) === "[object Date]" && a.toString() !== "Invalid Date" && !isNaN(a)
};
baidu.event._eventFilter = baidu.event._eventFilter || {};
baidu.event._eventFilter._crossElementBoundary = function(a, d) {
	var c = d.relatedTarget,
		b = d.currentTarget;
	if (c === false || b == c || (c && (c.prefix == "xul" || baidu.dom.contains(b, c)))) {
		return
	}
	return a.call(b, d)
};
baidu.event._eventFilter.mouseenter = window.attachEvent ? null : function(a, b, c) {
	return {
		type : "mouseover",
		listener : baidu.fn.bind(baidu.event._eventFilter._crossElementBoundary, this, c)
	}
};
baidu.event._eventFilter.mouseleave = window.attachEvent ? null : function(a, b, c) {
	return {
		type : "mouseout",
		listener : baidu.fn.bind(baidu.event._eventFilter._crossElementBoundary, this, c)
	}
};(function() {
	var d = baidu.browser,
		l = {
			keydown : 1,
			keyup : 1,
			keypress : 1
		},
		a = {
			click : 1,
			dblclick : 1,
			mousedown : 1,
			mousemove : 1,
			mouseup : 1,
			mouseover : 1,
			mouseout : 1
		},
		i = {
			abort : 1,
			blur : 1,
			change : 1,
			error : 1,
			focus : 1,
			load : d.ie ? 0 : 1,
			reset : 1,
			resize : 1,
			scroll : 1,
			select : 1,
			submit : 1,
			unload : d.ie ? 0 : 1
		},
		g = {
			scroll : 1,
			resize : 1,
			reset : 1,
			submit : 1,
			change : 1,
			select : 1,
			error : 1,
			abort : 1
		},
		k = {
			KeyEvents : [ "bubbles", "cancelable", "view", "ctrlKey", "altKey", "shiftKey", "metaKey", "keyCode", "charCode" ],
			MouseEvents : [ "bubbles", "cancelable", "view", "detail", "screenX", "screenY", "clientX", "clientY", "ctrlKey", "altKey", "shiftKey", "metaKey", "button", "relatedTarget" ],
			HTMLEvents : [ "bubbles", "cancelable" ],
			UIEvents : [ "bubbles", "cancelable", "view", "detail" ],
			Events : [ "bubbles", "cancelable" ]
		};
	baidu.object.extend(g, l);baidu.object.extend(g, a);
	function c(r, p) {
		var o = 0,
			n = r.length,
			q = {};
		for (; o < n; o++) {
			q[r[o]] = p[r[o]];
			delete p[r[o]]
		}
		return q
	}
	function f(p, o, n) {
		n = baidu.object.extend({}, n);var q = baidu.object.values(c(k[o], n)),
			r = document.createEvent(o);
		q.unshift(p);
		if ("KeyEvents" == o) {
			r.initKeyEvent.apply(r, q)
		} else {
			if ("MouseEvents" == o) {
				r.initMouseEvent.apply(r, q)
			} else {
				if ("UIEvents" == o) {
					r.initUIEvent.apply(r, q)
				} else {
					r.initEvent.apply(r, q)
				}
			}
		}
		baidu.object.extend(r, n);return r
	}
	function b(n) {
		var o;
		if (document.createEventObject) {
			o = document.createEventObject();baidu.object.extend(o, n)
		}
		return o
	}
	function h(q, n) {
		n = c(k.KeyEvents, n);var r;
		if (document.createEvent) {
			try {
				r = f(q, "KeyEvents", n)
			} catch (p) {
				try {
					r = f(q, "Events", n)
				} catch (o) {
					r = f(q, "UIEvents", n)
				}
			}
		} else {
			n.keyCode = n.charCode > 0 ? n.charCode : n.keyCode;
			r = b(n)
		}
		return r
	}
	function m(o, n) {
		n = c(k.MouseEvents, n);var p;
		if (document.createEvent) {
			p = f(o, "MouseEvents", n);
			if (n.relatedTarget && !p.relatedTarget) {
				if ("mouseout" == o.toLowerCase()) {
					p.toElement = n.relatedTarget
				} else {
					if ("mouseover" == o.toLowerCase()) {
						p.fromElement = n.relatedTarget
					}
				}
			}
		} else {
			n.button = n.button == 0 ? 1 : n.button == 1 ? 4 : baidu.lang.isNumber(n.button) ? n.button : 0;
			p = b(n)
		}
		return p
	}
	function j(p, n) {
		n.bubbles = g.hasOwnProperty(p);
		n = c(k.HTMLEvents, n);var r;
		if (document.createEvent) {
			try {
				r = f(p, "HTMLEvents", n)
			} catch (q) {
				try {
					r = f(p, "UIEvents", n)
				} catch (o) {
					r = f(p, "Events", n)
				}
			}
		} else {
			r = b(n)
		}
		return r
	}
	baidu.event.fire = function(o, p, n) {
		var q;
		p = p.replace(/^on/i, "");
		o = baidu.dom._g(o);
		n = baidu.object.extend({
			bubbles : true,
			cancelable : true,
			view : window,
			detail : 1,
			screenX : 0,
			screenY : 0,
			clientX : 0,
			clientY : 0,
			ctrlKey : false,
			altKey : false,
			shiftKey : false,
			metaKey : false,
			keyCode : 0,
			charCode : 0,
			button : 0,
			relatedTarget : null
		}, n);
		if (l[p]) {
			q = h(p, n)
		} else {
			if (a[p]) {
				q = m(p, n)
			} else {
				if (i[p]) {
					q = j(p, n)
				} else {
					throw (new Error(p + " is not support!"))
				}
			}
		}
		if (q) {
			if (o.dispatchEvent) {
				o.dispatchEvent(q)
			} else {
				if (o.fireEvent) {
					o.fireEvent("on" + p, q)
				}
			}
		}
	}
})();
baidu.event.once = function(a, b, c) {
	a = baidu.dom._g(a);
	function d(f) {
		c.call(a, f);baidu.event.un(a, b, d)
	}
	baidu.event.on(a, b, d);return a
};(function() {
	var c = /^\#[\da-f]{6}$/i,
		b = /^rgb\((\d+), (\d+), (\d+)\)$/,
		a = {
			black : "#000000",
			silver : "#c0c0c0",
			gray : "#808080",
			white : "#ffffff",
			maroon : "#800000",
			red : "#ff0000",
			purple : "#800080",
			fuchsia : "#ff00ff",
			green : "#008000",
			lime : "#00ff00",
			olive : "#808000",
			yellow : "#ffff0",
			navy : "#000080",
			blue : "#0000ff",
			teal : "#008080",
			aqua : "#00ffff"
		};
	baidu.string.formatColor = function(f) {
		if (c.test(f)) {
			return f
		} else {
			if (b.test(f)) {
				for (var k, j = 1, f = "#"; j < 4; j++) {
					k = parseInt(RegExp["\x24" + j]).toString(16);
					f += ("00" + k).substr(k.length)
				}
				return f
			} else {
				if (/^\#[\da-f]{3}$/.test(f)) {
					var h = f.charAt(1),
						g = f.charAt(2),
						d = f.charAt(3);
					return "#" + h + h + g + g + d + d
				} else {
					if (a[f]) {
						return a[f]
					}
				}
			}
		}
		return ""
	}
})();
baidu.array.map = function(g, f, b) {
	var d = [],
		c = 0,
		a = g.length;
	for (; c < a; c++) {
		d[c] = f.call(b || g, g[c], c)
	}
	return d
};
baidu.dom.getParent = function(a) {
	a = baidu.dom._g(a);return a.parentElement || a.parentNode || null
};
baidu.dom.setPosition = function(b, a) {
	return baidu.dom.setStyles(b, {
		left : a.left - (parseFloat(baidu.dom.getStyle(b, "margin-left")) || 0),
		top : a.top - (parseFloat(baidu.dom.getStyle(b, "margin-top")) || 0)
	})
};
baidu.element.extend = function(a) {
	var b = baidu.element;
	baidu.object.each(a, function(d, c) {
		b.Element.prototype[c] = baidu.element._toChainFunction(d, -1)
	})
};
baidu.number.randomInt = function(b, a) {
	return Math.floor(Math.random() * (a - b + 1) + b)
};
baidu.object.map = function(d, c) {
	var b = {};
	for (var a in d) {
		if (d.hasOwnProperty(a)) {
			b[a] = c(d[a], a)
		}
	}
	return b
};
baidu.array.contains = function(a, b) {
	return (baidu.array.indexOf(a, b) >= 0)
};
baidu.array.empty = function(a) {
	a.length = 0
};
baidu.array.every = function(f, d, b) {
	var c = 0,
		a = f.length;
	for (; c < a; c++) {
		if (c in f && !d.call(b || f, f[c], c)) {
			return false
		}
	}
	return true
};
baidu.array.reduce = function(g, c, d) {
	var b = 0,
		a = g.length,
		f = 0;
	if (arguments.length < 3) {
		for (; b < a; b++) {
			d = g[b++];
			f = 1;break
		}
		if (!f) {
			return
		}
	}
	for (; b < a; b++) {
		if (b in g) {
			d = c(d, g[b], b, g)
		}
	}
	return d
};
baidu.array.some = function(f, d, b) {
	var c = 0,
		a = f.length;
	for (; c < a; c++) {
		if (c in f && d.call(b || f, f[c], c)) {
			return true
		}
	}
	return false
};
baidu.page.load = function(c, k, f) {
	k = k || {};
	var i = baidu.page.load,
		a = i._cache = i._cache || {},
		h = i._loadingCache = i._loadingCache || {},
		g = k.parallel;
	function d() {
		for (var m = 0, l = c.length; m < l; ++m) {
			if (!a[c[m].url]) {
				setTimeout(arguments.callee, 10);return
			}
		}
		k.onload()
	}
	function b(n, p) {
		var o,
			m,
			l;
		switch (n.type.toLowerCase()) {
		case "css":
			o = document.createElement("link");o.setAttribute("rel", "stylesheet");o.setAttribute("type", "text/css");
			break;case "js":
			o = document.createElement("script");o.setAttribute("type", "text/javascript");o.setAttribute("charset", n.charset || "UTF8");
			break;case "html":
			o = document.createElement("iframe");o.frameBorder = "none";
			break;default:
			return
		}
		l = function() {
			if (!m && (!this.readyState || this.readyState === "loaded" || this.readyState === "complete")) {
				m = true;baidu.un(o, "load", l);baidu.un(o, "readystatechange", l);p.call(window, o)
			}
		};baidu.on(o, "load", l);baidu.on(o, "readystatechange", l);
		if (n.type == "css") {
			(function() {
				if (m) {
					return
				}
				try {
					o.sheet.cssRule
				} catch (q) {
					setTimeout(arguments.callee, 20);return
				}
				m = true;p.call(window, o)
			})()
		}
		o.href = o.src = n.url;document.getElementsByTagName("head")[0].appendChild(o)
	}
	baidu.lang.isString(c) && (c = [ {
		url : c
	} ]);
	if (!(c && c.length)) {
		return
	}
	function j(n) {
		var m = n.url,
			o = !!g,
			l,
			p = function(q) {
				a[n.url] = q;
				delete h[n.url];
				if (baidu.lang.isFunction(n.onload)) {
					if (false === n.onload.call(window, q)) {
						return
					}
				}
				!g && i(c.slice(1), k, true);
				if ((!f) && baidu.lang.isFunction(k.onload)) {
					d()
				}
			};
		n.type = n.type || m.substr(m.lastIndexOf(".") + 1);
		n.requestType = n.requestType || (n.type == "html" ? "ajax" : "dom");
		if (l = a[n.url]) {
			p(l);return o
		}
		if (!k.refresh && h[n.url]) {
			setTimeout(function() {
				j(n)
			}, 10);return o
		}
		h[n.url] = true;
		if (n.requestType.toLowerCase() == "dom") {
			b(n, p)
		} else {
			baidu.ajax.get(n.url, function(r, q) {
				p(q)
			})
		}
		return o
	}
	baidu.each(c, j)
};
baidu.page.lazyLoadImage = function(a) {
	a = a || {};
	a.preloadHeight = a.preloadHeight || 0;baidu.dom.ready(function() {
		var f = document.getElementsByTagName("IMG"),
			g = f,
			h = f.length,
			d = 0,
			l = c(),
			k = "data-tangram-ori-src",
			j;
		if (a.className) {
			g = [];
			for (; d < h; ++d) {
				if (baidu.dom.hasClass(f[d], a.className)) {
					g.push(f[d])
				}
			}
		}
		function c() {
			return baidu.page.getScrollTop() + baidu.page.getViewHeight() + a.preloadHeight
		}
		for (d = 0, h = g.length; d < h; ++d) {
			j = g[d];
			if (baidu.dom.getPosition(j).top > l) {
				j.setAttribute(k, j.src);
				a.placeHolder ? j.src = a.placeHolder : j.removeAttribute("src")
			}
		}
		var b = function() {
			var n = c(),
				p,
				q = true,
				o = 0,
				m = g.length;
			for (; o < m; ++o) {
				j = g[o];
				p = j.getAttribute(k);p && (q = false);
				if (baidu.dom.getPosition(j).top < n && p) {
					j.src = p;j.removeAttribute(k);baidu.lang.isFunction(a.onlazyload) && a.onlazyload(j)
				}
			}
			q && baidu.un(window, "scroll", b)
		};
		baidu.on(window, "scroll", b)
	})
};(function() {
	var b = function(c) {
		return baidu.lang.isObject(c) && !baidu.lang.isFunction(c)
	};
	function a(h, g, f, d, c) {
		if (g.hasOwnProperty(f)) {
			if (c && b(h[f])) {
				baidu.object.merge(h[f], g[f], {
					overwrite : d,
					recursive : c
				})
			} else {
				if (d || !(f in h)) {
					h[f] = g[f]
				}
			}
		}
	}
	baidu.object.merge = function(j, c, l) {
		var f = 0,
			m = l || {},
			h = m.overwrite,
			k = m.whiteList,
			d = m.recursive,
			g;
		if (k && k.length) {
			g = k.length;
			for (; f < g; ++f) {
				a(j, c, k[f], h, d)
			}
		} else {
			for (f in c) {
				a(j, c, f, h, d)
			}
		}
		return j
	}
})();
baidu.platform = baidu.platform || {};
baidu.platform.isAndroid = /android/i.test(navigator.userAgent);
baidu.platform.isIpad = /ipad/i.test(navigator.userAgent);
baidu.platform.isIphone = /iphone/i.test(navigator.userAgent);
baidu.platform.isMacintosh = /macintosh/i.test(navigator.userAgent);
baidu.platform.isWindows = /windows/i.test(navigator.userAgent);
baidu.platform.isX11 = /x11/i.test(navigator.userAgent);