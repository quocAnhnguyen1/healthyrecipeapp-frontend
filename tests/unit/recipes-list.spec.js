import { mount } from '@vue/test-utils'
import RecipesList from '@/components/RecipesList'
import Recipes from '@/views/Recipes'

describe('Testing RecipeCardList.vue', () => {
  it('should render a recipe block for each recipe', () => {
    const wrapper = mount(RecipesList, {
      propsData: {
        recipes: [
          {
            recipeID: 1,
            recipeName: 'Spaghetti',
            recipeDescription: 'cremige Spaghetti Carbonara',
            time: 30,
            difficulty: 'easy'
          },
          {
            recipeID: 2,
            recipeName: 'Portein Wraps',
            recipeDescription: 'billige und proteinreiche Wraps',
            time: 30,
            difficulty: 'easy'
          }
        ]
      }
    })

    const recipes = wrapper.findAllComponents(Recipes)
    expect(recipes.length).toBe(2)
  })
})
