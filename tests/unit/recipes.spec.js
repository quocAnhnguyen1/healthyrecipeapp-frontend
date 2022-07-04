import { mount } from '@vue/test-utils'
import Recipes from '@/views/Recipes'
import RecipesList from '@/components/RecipesList'
import RecipesCreateForm from '@/components/RecipesCreateForm'

describe('Testing Recipes.vue', () => {
  it('should show page title', () => {
    const wrapper = mount(Recipes)

    expect(wrapper.text()).toMatch('Recipes')
  })
  it('should have recipes list component', () => {
    const wrapper = mount(Recipes)

    const recipeList = wrapper.findComponent(RecipesList)
    expect(recipeList.exists()).toBeTruthy()
  })

  it('should have recipes create form component', () => {
    const wrapper = mount(Recipes)

    const createForm = wrapper.findComponent(RecipesCreateForm)
    expect(createForm.exists()).toBeTruthy()
  })
})
