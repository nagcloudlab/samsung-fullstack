

// highlight custom directive
const vHighlight = (el, binding) => {
    const color = binding.value || 'yellow';
    // on mouseover, set background color to color value
    el.onmouseover = () => {
        el.style.backgroundColor = color;
    }
    // on mouseout, set background color to null
    el.onmouseout = () => {
        el.style.backgroundColor = null;
    }
};

export { vHighlight };