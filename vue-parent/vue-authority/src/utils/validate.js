export function isExternal(url) {
  return /^(https?:|mailto:|tel:)/.test(url)
}

export function validUsername(str) {
  const valid_map = ['admin', 'editor']
  return valid_map.indexOf(str.trim()) >= 0
}
